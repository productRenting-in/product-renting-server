package com.product.renting.order.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class CreateInventoryItemRequest {

    @NotNull(message = "productId is required")
    private UUID productId;

    /**
     * Required for BULK
     * Optional / ignored for SERIALIZED
     */
    @Positive(message = "quantity must be greater than zero")
    private BigInteger quantity;
}
