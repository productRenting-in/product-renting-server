package com.product.renting.order.repository;

import com.product.renting.order.entity.Product;
import com.product.renting.order.enumeration.TrackingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    boolean existsByProductNameIgnoreCaseAndTrackingType(String productName, TrackingType trackingType);

    @Query("""
        SELECT p, pp
        FROM Product p
        JOIN p.pricingList pp
        WHERE pp.effectiveTo IS NULL
    """)
    List<Object[]> findAllWithActivePricing();

    @Query("""
        SELECT p, pp
        FROM Product p
        JOIN p.pricingList pp
        WHERE p.category.categoryId = :categoryId
          AND pp.effectiveTo IS NULL
    """)
    List<Object[]> findByCategoryWithActivePricing(UUID categoryId);

}
