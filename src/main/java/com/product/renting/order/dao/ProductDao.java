package com.product.renting.order.dao;

import com.product.renting.order.entity.Product;

import java.util.List;
import java.util.UUID;

/**
 * Data Access Object interface for Product entity.
 * Defines operations for accessing and manipulating Product data.
 */
public interface ProductDao {

    /**
     * Retrieve all products
     *
     * @return A list of all products
     */
    List<Product> getAll();

    /**
     * Create a new product
     *
     * @return the created Product
     */
    Product create(Product product);

    boolean existsByProductName(String productName);

    Product save(Product product);


    List<Object[]> findAllWithActivePricing();

    List<Object[]> findByCategoryWithActivePricing(UUID categoryId);
}
