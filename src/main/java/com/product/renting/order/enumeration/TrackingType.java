package com.product.renting.order.enumeration;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "The type of the product tracking",
        example = "BULK",
        allowableValues = {
                "BULK",
                "SERIALIZED"
        }
)
public enum TrackingType {
    BULK,
    SERIALIZED
}
