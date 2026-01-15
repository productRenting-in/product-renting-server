package com.product.renting.order.dao.impl;

import com.product.renting.common.exception.ResourceNotCreatedException;
import com.product.renting.common.exception.ResourceNotFoundException;
import com.product.renting.common.exception.ResourceNotUpdatedException;
import com.product.renting.order.dao.CategoryDao;
import com.product.renting.order.entity.Category;
import com.product.renting.order.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CategoryDaoImpl implements CategoryDao {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        log.debug("DAO - Fetching all categories");
        List<Category> categories = categoryRepository.findAll();
        log.debug("DAO - Found {} categories", categories.size());
        return categories;
    }

    @Override
    public Category create(Category category) {
        try {
            log.debug("DAO - Creating category");
            return categoryRepository.save(category);
        } catch (Exception ex) {
            log.error("DAO - Error while creating category", ex);
            throw new ResourceNotCreatedException("DAO - Error while creating category", ex);
        }
    }

    @Override
    public Category update(Category category) {
        UUID categoryId = category.getCategoryId();
        try {
            log.debug("DAO - Updating category with id {}", categoryId);
            return categoryRepository.save(category);
        } catch (Exception ex) {
            log.error("DAO - Error while updating category with id {}", categoryId, ex);
            throw new ResourceNotUpdatedException("DAO - Error while updating category with id: " + categoryId, ex);
        }
    }

    @Override
    public Category getByIdOrThrow(UUID categoryId) {
        log.debug("DAO - Fetching category with id {}", categoryId);
        return categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found for id: " + categoryId)
                );
    }

    @Override
    public Optional<Category> getCategoryById(UUID categoryId) {
        log.debug("DAO - Fetching category with id {}", categoryId);
        return categoryRepository.findById(categoryId);
    }

    @Override
    public boolean categoryExistsBySlug(String categorySlug) {
        log.debug("DAO - Checking if category exists with Slug {}", categorySlug);
        boolean result = categoryRepository.existsByCategorySlugIgnoreCase(categorySlug);
        log.debug("DAO - Category exists with Slug {} result {}", categorySlug, result);
        return result;
    }
}
