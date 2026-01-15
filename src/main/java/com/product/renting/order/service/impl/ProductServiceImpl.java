package com.product.renting.order.service.impl;

import com.product.renting.common.exception.DuplicateResourceException;
import com.product.renting.common.exception.ResourceNotFoundException;
import com.product.renting.order.dao.CategoryDao;
import com.product.renting.order.dao.ProductDao;
import com.product.renting.order.dao.ProductPricingDao;
import com.product.renting.order.dto.request.ProductRequest;
import com.product.renting.order.dto.response.ProductResponse;
import com.product.renting.order.entity.Category;
import com.product.renting.order.entity.Product;
import com.product.renting.order.entity.ProductPricing;
import com.product.renting.order.enumeration.TrackingType;
import com.product.renting.order.mapper.ProductMapper;
import com.product.renting.order.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;
    private final ProductMapper productMapper;
    private final CategoryDao categoryDao;
    private final ProductPricingDao productPricingDao;

    @Override
    @Transactional
    public List<ProductResponse> getAll() {
        List<Object[]> result = productDao.findAllWithActivePricing();

        return result.stream()
                .map(row -> {
                    Product product = (Product) row[0];
                    ProductPricing pricing = (ProductPricing) row[1];

                    return productMapper.toResponse(product, pricing);
                })
                .toList();
    }

    @Override
    public List<ProductResponse> getProductsByCategory(UUID categoryId) {
        List<Object[]> result = productDao.findByCategoryWithActivePricing(categoryId);

        return result.stream()
                .map(row -> {
                    Product product = (Product) row[0];
                    ProductPricing pricing = (ProductPricing) row[1];
                    return productMapper.toResponse(product, pricing);
                })
                .toList();
    }

    @Override
    @Transactional
    public ProductResponse addProduct(TrackingType trackingType, ProductRequest productRequest) {

        Category category = categoryDao.getCategoryById(productRequest.getCategoryId()).orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + productRequest.getCategoryId()));
        boolean exists = productDao.existsByProductNameAndTrackingType(productRequest.getProductName(), trackingType);
        if (exists) {
            throw new DuplicateResourceException("Product already exists with name: " + productRequest.getProductName() + " and tracking Type: " + trackingType);
        }
        Product product = productMapper.toEntity(productRequest);
        product.setTrackingType(trackingType);
        product.setCategory(category);

        // Create ProductPricing entity
        ProductPricing productPricing = ProductPricing.builder()
                .pricePerDay(productRequest.getPricePerDay())
                .pricePerWeek(productRequest.getPricePerWeek())
                .pricePerMonth(productRequest.getPricePerMonth())
                .effectiveFrom(Instant.now())
                .effectiveTo(null)
                .product(product)
                .build();

        product.setPricingList(List.of(productPricing));

        Product savedProduct = productDao.save(product);
        return productMapper.toResponse(savedProduct, productPricing);
    }

}
