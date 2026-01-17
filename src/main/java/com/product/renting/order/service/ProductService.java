package com.product.renting.order.service;

import com.product.renting.order.dto.request.ProductRequest;
import com.product.renting.order.dto.response.ProductResponse;
import com.product.renting.order.enumeration.TrackingType;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<ProductResponse> getAll();

    List<ProductResponse> getProductsByCategory(UUID categoryId);

    ProductResponse addProduct(ProductRequest productRequest);
}
