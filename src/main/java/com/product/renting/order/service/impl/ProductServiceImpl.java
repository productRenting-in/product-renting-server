package com.product.renting.order.service.impl;

import com.product.renting.order.dao.ProductDao;
import com.product.renting.order.dto.response.ProductResponse;
import com.product.renting.order.entity.Product;
import com.product.renting.order.mapper.ProductMapper;
import com.product.renting.order.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;
    private final ProductMapper productMapper;

    @Override
    public List<ProductResponse> getAll() {
        List<Product> productList = productDao.getAll();
        return productMapper.toProductResponseList(productList);
    }
}
