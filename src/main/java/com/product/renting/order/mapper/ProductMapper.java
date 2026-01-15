package com.product.renting.order.mapper;

import com.product.renting.common.config.MapstructMapperConfig;
import com.product.renting.order.dto.request.ProductRequest;
import com.product.renting.order.dto.response.ProductResponse;
import com.product.renting.order.entity.Product;
import com.product.renting.order.entity.ProductPricing;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

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

    @Mapping(source = "product.productId", target = "productId")
    @Mapping(source = "product.productName", target = "productName")
    @Mapping(source = "product.productDescription", target = "productDescription")
    @Mapping(source = "product.category", target = "category")
    @Mapping(source = "product.trackingType", target = "trackingType")
    // Map pricing fields from the second parameter
    @Mapping(source = "pricing.pricePerDay", target = "pricePerDay")
    @Mapping(source = "pricing.pricePerWeek", target = "pricePerWeek")
    @Mapping(source = "pricing.pricePerMonth", target = "pricePerMonth")
    ProductResponse toResponse(Product product, ProductPricing pricing);

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
