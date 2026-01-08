package com.product.renting.order.dao.impl;

import com.product.renting.order.dao.ProductPricingDao;
import com.product.renting.order.entity.ProductPricing;
import com.product.renting.order.repository.ProductPricingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class ProductPricingDaoImpl implements ProductPricingDao {

    ProductPricingRepository productPricingRepository;

    @Override
    public ProductPricing saveProductPricing(ProductPricing productPricing) {
        log.info("ProductPricingDaoImpl - saving ProductPricing with productPricing={}", productPricing);
        ProductPricing savedProductPricing = productPricingRepository.save(productPricing);
        log.info("ProductPricingDaoImpl - savedProductPricing={}", savedProductPricing);
        return savedProductPricing;
    }
}
