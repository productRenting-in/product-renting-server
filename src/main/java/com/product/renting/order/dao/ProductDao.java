package com.product.renting.order.dao;

import com.product.renting.order.entity.Product;

import java.util.List;

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
}
