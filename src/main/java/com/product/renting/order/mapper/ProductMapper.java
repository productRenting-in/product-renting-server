package com.product.renting.order.mapper;

import com.product.renting.common.config.MapstructMapperConfig;
import com.product.renting.order.dto.request.ProductRequest;
import com.product.renting.order.dto.response.ProductResponse;
import com.product.renting.order.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class)
public interface ProductMapper {

    /**
     * Converts a Product entity to a Product response.
     *
     * @param entity the Product to convert
     * @return the converted Product response
     */
    ProductResponse toResponse(Product entity);

    /**
     * Converts a list of Product entity to a Product response list.
     *
     * @param entityList the Product entities to convert
     * @return the converted Product response list
     */
    List<ProductResponse> toResponses(List<Product> entityList);

    /**
     * Converts a Product request to a Product entity.
     *
     * @param request the Product request to convert
     * @return the converted Product entity
     */
    Product toEntity(ProductRequest request);
}
