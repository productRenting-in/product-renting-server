package com.product.renting.order.controller.impl;

import com.product.renting.order.controller.InventoryItemController;
import com.product.renting.order.dto.request.CreateInventoryItemRequest;
import com.product.renting.order.dto.request.UpdateInventoryItemRequest;
import com.product.renting.order.dto.response.InventoryItemResponse;
import com.product.renting.order.service.InventoryItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InventoryItemControllerImpl implements InventoryItemController {

    private final InventoryItemService inventoryItemService;

    @Override
    public ResponseEntity<InventoryItemResponse> create(CreateInventoryItemRequest request) {
        InventoryItemResponse response = inventoryItemService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<InventoryItemResponse> update(UpdateInventoryItemRequest request) {
        InventoryItemResponse response = inventoryItemService.update(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
