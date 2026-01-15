package com.product.renting.order.dao.impl;

import com.product.renting.common.exception.DuplicateResourceException;
import com.product.renting.order.dao.ProductDao;
import com.product.renting.order.entity.Product;
import com.product.renting.order.enumeration.TrackingType;
import com.product.renting.order.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao {

    private final ProductRepository productRepository;


    @Override
    public List<Product> getAll() {
        log.debug("DAO - Fetching all products");
        List<Product> products = productRepository.findAll();
        log.debug("DAO - Found {} products", products.size());
        return products;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean existsByProductNameAndTrackingType(String productName, TrackingType trackingType) {
        log.debug("DAO - Checking if product exists by productName {} and trackingType {}", productName, trackingType);
        return productRepository.existsByProductNameIgnoreCaseAndTrackingType(productName, trackingType);
    }

    @Override
    public Product save(Product product) {
        log.debug("DAO - Saving product {}", product);
        Product savedProduct = productRepository.save(product);
        log.debug("DAO - Saved product {}", savedProduct);
        return savedProduct;
    }

    @Override
    public List<Object[]> findAllWithActivePricing() {
        return productRepository.findAllWithActivePricing();
    }

    @Override
    public List<Object[]> findByCategoryWithActivePricing(UUID categoryId) {
        return productRepository.findByCategoryWithActivePricing(categoryId);
    }
}
