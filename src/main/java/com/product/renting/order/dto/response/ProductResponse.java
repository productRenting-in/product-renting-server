package com.product.renting.order.dto.response;

import com.product.renting.order.entity.Category;
import com.product.renting.order.enumeration.TrackingType;
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
public class ProductResponse {
    private UUID productId;
    private String productName;
    private String productDescription;
    private TrackingType trackingType;
    private CategoryResponse category;
    private BigDecimal pricePerDay;
    private BigDecimal pricePerWeek;
    private BigDecimal pricePerMonth;
}
