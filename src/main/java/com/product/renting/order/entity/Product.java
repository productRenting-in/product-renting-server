package com.product.renting.order.entity;

import com.product.renting.common.constant.DbConstants;
import com.product.renting.common.entity.Auditable;
import com.product.renting.order.enumeration.TrackingType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = DbConstants.PRODUCT)
public class Product extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = DbConstants.PRODUCT_ID)
    private UUID productId;

    @Column(name = DbConstants.PRODUCT_NAME)
    private String productName;

    @Column(name = DbConstants.PRODUCT_DESCRIPTION)
    private String productDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = DbConstants.TRACKING_TYPE)
    private TrackingType trackingType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DbConstants.CATEGORY_ID)
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductPricing> pricingList = new ArrayList<>();
}
