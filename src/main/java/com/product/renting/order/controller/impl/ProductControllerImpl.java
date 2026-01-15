package com.product.renting.order.controller.impl;

import com.product.renting.order.controller.ProductController;
import com.product.renting.order.dto.request.ProductRequest;
import com.product.renting.order.dto.response.ProductResponse;
import com.product.renting.order.enumeration.TrackingType;
import com.product.renting.order.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;

    @Override
    public ResponseEntity<List<ProductResponse>> getAll() {
        List<ProductResponse> response = productService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductResponse>> getProductsByCategory(UUID categoryId) {
        List<ProductResponse> response = productService.getProductsByCategory(categoryId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductResponse> addProduct(TrackingType trackingType, ProductRequest productRequest) {
        ProductResponse savedProductResponse = productService.addProduct(trackingType, productRequest);
        return new ResponseEntity<>(savedProductResponse, HttpStatus.OK);
    }
}
