package com.product.renting.order.enumeration;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "The type of the product tracking",
        example = "BULK"
)
public enum TrackingType {
    BULK,
    SERIALIZED
}
