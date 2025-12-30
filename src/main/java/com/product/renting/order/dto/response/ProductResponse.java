package com.product.renting.order.dto.response;

import com.product.renting.order.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private UUID productId;
    private String productName;
    private String productDescription;
    private Category category;
}
