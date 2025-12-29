package com.product.renting.order.entity;

import com.product.renting.common.constant.DbConstants;
import com.product.renting.common.entity.Auditable;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = DbConstants.PRODUCT_PRICING)
@EqualsAndHashCode(callSuper = true)
public class ProductPricing extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = DbConstants.PRODUCT_PRICING_ID)
    private UUID productPricingId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DbConstants.PRODUCT_ID)
    private Product product;

    @Column(name = DbConstants.PRICE_PER_DAY)
    private BigDecimal pricePerDay;

    @Column(name = DbConstants.PRICE_PER_WEEK)
    private BigDecimal pricePerWeek;

    @Column(name = DbConstants.PRICE_PER_MONTH)
    private BigDecimal pricePerMonth;

    @Column(name = DbConstants.PRODUCT_PRICING_EFFECTIVE_FROM)
    private LocalDateTime effectiveFrom;

    @Column(name = DbConstants.PRODUCT_PRICING_EFFECTIVE_TO)
    private LocalDateTime effectiveTo;

}
