package com.product.renting.order.dao;


import com.product.renting.order.entity.ProductPricing;

/**
 * Data Access Object interface for ProductPricing entity.
 * Defines operations for accessing and manipulating ProductPricing data.
 */
public interface ProductPricingDao {

    ProductPricing saveProductPricing(ProductPricing productPricing);
}
