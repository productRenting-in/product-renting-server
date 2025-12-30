package com.product.renting.order.entity;

import com.product.renting.common.constant.DbConstants;
import com.product.renting.common.entity.Auditable;
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
@Table(name = DbConstants.CATEGORY)
@EqualsAndHashCode(callSuper = true)
public class Category extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = DbConstants.CATEGORY_ID)
    private UUID categoryId;

    @Column(name = DbConstants.CATEGORY_NAME)
    private String categoryName;

    @Column(name = DbConstants.CATEGORY_DESCRIPTION)
    private String categoryDescription;

    @Column(name = DbConstants.CATEGORY_SLUG)
    private String categorySlug;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList<>();
}

