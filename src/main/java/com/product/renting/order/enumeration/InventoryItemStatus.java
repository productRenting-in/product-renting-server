package com.product.renting.order.enumeration;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "The status of the inventory item",
        example = "AVAILABLE",
        allowableValues = {
                "AVAILABLE",
                "RENTED"
        }
)
public enum InventoryItemStatus {
    AVAILABLE,
    RENTED
}
