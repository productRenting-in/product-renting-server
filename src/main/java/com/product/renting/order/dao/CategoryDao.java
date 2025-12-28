package com.product.renting.order.dao;

import com.product.renting.order.entity.Category;

import java.util.List;
import java.util.UUID;

/**
 * Data Access Object interface for Category entity.
 * Defines operations for accessing and manipulating Category data.
 */
public interface CategoryDao {

    /**
     * Retrieve all categories
     *
     * @return A list of all categories
     */
    List<Category> getAll();

    /**
     * Create a new category
     *
     * @return the created category
     */
    Category create(Category category);

    /**
     * Update an existing category
     *
     * @return the updated category
     */
    Category update(Category category);

    /**
     * Get a category by ID if exists
     *
     * @return the existing category
     */
    Category getByIdOrThrow(UUID categoryId);
}
