package com.product.renting.order.dto.request;

import com.product.renting.order.enumeration.TrackingType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    @NotNull(message = "categoryId is required")
    private UUID categoryId;

    @NotBlank(message = "productName is required")
    private String productName;

    private String productDescription;

    @NotBlank(message = "trackingType is required")
    private TrackingType trackingType;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be strictly greater than 0")
    private BigDecimal pricePerDay;
    private BigDecimal pricePerWeek;
    private BigDecimal pricePerMonth;
}
