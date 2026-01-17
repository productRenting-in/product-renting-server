package com.product.renting.order.dto.response;

import com.product.renting.order.enumeration.InventoryItemStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItemResponse {
    private UUID inventoryItemId;
    private UUID productId;
    private String serialNumber;
    private BigInteger quantity;
    private InventoryItemStatus inventoryItemStatus;
}
