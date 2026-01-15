package com.product.renting.order.enumeration;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "The type of the inventory reservation",
        example = "ORDER"
)
public enum InventoryReservationType {
    CART,
    ORDER
}
