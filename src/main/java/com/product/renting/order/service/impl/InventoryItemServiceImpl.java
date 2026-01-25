package com.product.renting.order.service.impl;

import com.product.renting.common.exception.DuplicateResourceException;
import com.product.renting.common.exception.ValidationException;
import com.product.renting.order.dao.InventoryItemDao;
import com.product.renting.order.dao.ProductDao;
import com.product.renting.order.dto.request.CreateInventoryItemRequest;
import com.product.renting.order.dto.request.UpdateInventoryItemRequest;
import com.product.renting.order.dto.response.InventoryItemResponse;
import com.product.renting.order.entity.InventoryItem;
import com.product.renting.order.entity.Product;
import com.product.renting.order.enumeration.InventoryItemStatus;
import com.product.renting.order.enumeration.TrackingType;
import com.product.renting.order.mapper.InventoryItemMapper;
import com.product.renting.order.service.InventoryItemService;
import com.product.renting.order.service.SerialNumberGeneratorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryItemServiceImpl implements InventoryItemService {

    private final InventoryItemMapper inventoryItemMapper;
    private final ProductDao productDao;
    private final SerialNumberGeneratorService serialNumberGeneratorService;
    private final InventoryItemDao inventoryItemDao;

    @Override
    public InventoryItemResponse create(CreateInventoryItemRequest request) {
        UUID productId = request.getProductId();
        Product product = productDao.getByIdOrThrow(productId);
        validateCreateRequest(product, request);
        InventoryItem inventoryItem = inventoryItemMapper.toCreateEntity(request);
        inventoryItem.setProduct(product);

        // Generate serial number for SERIALIZED items
        if (product.getTrackingType() == TrackingType.SERIALIZED) {
            inventoryItem.setSerialNumber(serialNumberGeneratorService.generateSerialNumber(product));
        }
        InventoryItem saved = inventoryItemDao.create(inventoryItem);
        return inventoryItemMapper.toResponse(saved);
    }

    private void validateCreateRequest(Product product, CreateInventoryItemRequest request) {
        if (product.getTrackingType() == TrackingType.SERIALIZED && request.getQuantity() == null) {
            request.setQuantity(BigInteger.ONE);
        }

        validateByTrackingType(
                product.getTrackingType(),
                request.getQuantity(),
                true,
                product.getProductId()
        );
    }

    private void validateUpdateRequest(InventoryItem existing, UpdateInventoryItemRequest request) {
        TrackingType trackingType = existing.getProduct().getTrackingType();
        InventoryItemStatus newStatus = request.getInventoryItemStatus();

        // BULK items cannot be RENTED or RESERVED
        if (trackingType == TrackingType.BULK &&
                (newStatus == InventoryItemStatus.RENTED
                        || newStatus == InventoryItemStatus.RESERVED)) {

            throw new ValidationException(
                    "BULK inventory items cannot be marked as RENTED or RESERVED"
            );
        }

        // Quantity rules
        if (trackingType == TrackingType.SERIALIZED && request.getQuantity() == null) {
            request.setQuantity(BigInteger.ONE);
        }

        validateByTrackingType(
                trackingType,
                request.getQuantity(),
                false,
                existing.getProduct().getProductId()
        );
    }




    @Override
    public InventoryItemResponse update(UpdateInventoryItemRequest request) {
        InventoryItem existing = inventoryItemDao.getByIdOrThrow(request.getInventoryItemId());
        validateUpdateRequest(existing, request);
        existing.setQuantity(request.getQuantity());
        existing.setInventoryItemStatus(request.getInventoryItemStatus());
        InventoryItem saved = inventoryItemDao.update(existing);
        return inventoryItemMapper.toResponse(saved);
    }

    private void validateByTrackingType(
            TrackingType trackingType,
            BigInteger quantity,
            boolean checkDuplicate,
            UUID productId
    ) {
        switch (trackingType) {
            case BULK -> {
                if (quantity == null) {
                    throw new ValidationException("Quantity is required for BULK inventory items");
                }
                if (checkDuplicate && inventoryItemDao.existsByProductId(productId)) {
                    throw new DuplicateResourceException(
                            "BULK inventory stock is already present for product with ID: " + productId
                    );
                }
            }

            case SERIALIZED -> {
                if (quantity != null && quantity.compareTo(BigInteger.ONE) != 0) {
                    throw new ValidationException("Quantity must be 1 for SERIALIZED inventory items");
                }
            }

            default -> log.warn("Unknown tracking type: {}", trackingType);
        }
    }
}
