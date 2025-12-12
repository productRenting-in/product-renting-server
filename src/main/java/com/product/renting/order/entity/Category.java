package com.product.renting.order.entity;

import com.product.renting.common.constant.DbConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = DbConstants.CATEGORY)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = DbConstants.CATEGORY_ID)
    private UUID categoryId;

    @Column(name = DbConstants.CATEGORY_NAME)
    private String categoryName;

    @Column(name = DbConstants.CATEGORY_DESCRIPTION)
    private String categoryDescription;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList<>();
}

