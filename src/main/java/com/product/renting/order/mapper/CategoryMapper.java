package com.product.renting.order.mapper;

import com.product.renting.common.config.MapstructMapperConfig;
import com.product.renting.order.dto.request.CategoryRequest;
import com.product.renting.order.dto.response.CategoryResponse;
import com.product.renting.order.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class)
public interface CategoryMapper {

    /**
     * Converts a Category entity to a Category response.
     *
     * @param entity the Category to convert
     * @return the converted Category response
     */
    CategoryResponse toResponse(Category entity);

    /**
     * Converts a list of Category entity to a Category response list.
     *
     * @param entityList the Category entities to convert
     * @return the converted Category response list
     */
    List<CategoryResponse> toResponses(List<Category> entityList);

    /**
     * Converts a Category request to a Category entity.
     *
     * @param request the Category request to convert
     * @return the converted Category entity
     */
    Category toEntity(CategoryRequest request);
}
