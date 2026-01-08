package com.product.renting.order.service.impl;

import com.product.renting.common.exception.DuplicateResourceException;
import com.product.renting.common.util.SlugUtil;
import com.product.renting.order.dao.CategoryDao;
import com.product.renting.order.dto.request.CategoryRequest;
import com.product.renting.order.dto.response.CategoryResponse;
import com.product.renting.order.entity.Category;
import com.product.renting.order.mapper.CategoryMapper;
import com.product.renting.order.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    
    private final CategoryDao categoryDao;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse addCategory(CategoryRequest categoryRequest) {
        Category category = categoryMapper.toEntity(categoryRequest);
        String categorySlug = SlugUtil.generateSlug(category.getCategoryName().toLowerCase().trim());
        if(categoryDao.categoryExistsBySlug(categorySlug)){
            throw new DuplicateResourceException("Category with name " + categoryRequest.getCategoryName() + " already exists");
        }
        category.setCategorySlug(categorySlug);
        return categoryMapper.toResponse(categoryDao.create(category));
    }

    @Override
    public List<CategoryResponse> getAll() {
        List<Category> categoryList = categoryDao.getAll();
        return categoryMapper.toResponses(categoryList);
    }

}
