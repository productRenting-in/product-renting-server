package com.product.renting.order.service;

import com.product.renting.order.dto.request.CreateInventoryItemRequest;
import com.product.renting.order.dto.request.UpdateInventoryItemRequest;
import com.product.renting.order.dto.response.InventoryItemResponse;

public interface InventoryItemService {

    InventoryItemResponse create(CreateInventoryItemRequest request);

    InventoryItemResponse update(UpdateInventoryItemRequest request);
}