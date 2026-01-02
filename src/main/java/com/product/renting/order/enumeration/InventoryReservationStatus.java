package com.product.renting.order.enumeration;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "The status of the inventory reservation",
        example = "ACTIVE",
        allowableValues = {
                "ACTIVE",
                "CANCELLED"
        }
)
public enum InventoryReservationStatus {
    ACTIVE,
    CANCELLED
}
