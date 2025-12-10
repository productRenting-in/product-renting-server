package com.product.renting.order.mapper;

import com.product.renting.common.config.MapstructMapperConfig;
import com.product.renting.order.dto.response.ProductResponse;
import com.product.renting.order.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapstructMapperConfig.class)
public interface ProductMapper {

    /**
     * Converts a Product entity to a Product response.
     *
     * @param entity the AreaUnit to convert
     * @return the converted AreaUnit response
     */
    ProductResponse toProductResponse(Product entity);

    /**
     * Converts a list of Product entity to a Product response list.
     *
     * @param entityList the AreaUnit entities to convert
     * @return the converted AreaUnit response list
     */
    List<ProductResponse> toProductResponseList(List<Product> entityList);
}
