package com.product.renting.order.dto.request;

import com.product.renting.order.enumeration.InventoryItemStatus;
import jakarta.validation.constraints.NotNull;
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
public class UpdateInventoryItemRequest {

    @NotNull(message = "inventoryItemId is required")
    private UUID inventoryItemId;

    @NotNull(message = "inventoryItemStatus is required")
    private InventoryItemStatus inventoryItemStatus;

    /**
     * Required only for BULK tracking
     * Must be > 0
     */
    private BigInteger quantity;
}
