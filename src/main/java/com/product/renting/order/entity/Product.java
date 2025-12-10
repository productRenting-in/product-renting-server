package com.product.renting.order.entity;

import com.product.renting.common.constant.DbConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = DbConstants.PRODUCT_ID)
    private UUID productId;

    @Column(name = DbConstants.PRODUCT_NAME)
    private String productName;

    @Column(name = DbConstants.PRODUCT_DESCRIPTION)
    private String productDescription;

    @Column(name = DbConstants.PRODUCT_PRICE_PER_DAY)
    private String productPricePerDay;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = DbConstants.CATEGORY_ID)
//    private Category category;
}
