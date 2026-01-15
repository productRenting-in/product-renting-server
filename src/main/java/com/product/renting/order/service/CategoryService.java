package com.product.renting.order.service;

import com.product.renting.order.dto.request.CategoryRequest;
import com.product.renting.order.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse addCategory(CategoryRequest categoryRequest);

    List<CategoryResponse> getAll();
}
