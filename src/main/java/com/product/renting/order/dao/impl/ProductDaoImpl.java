package com.product.renting.order.dao.impl;

import com.product.renting.order.dao.ProductDao;
import com.product.renting.order.entity.Product;
import com.product.renting.order.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
