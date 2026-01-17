package com.product.renting.order.mapper;

import com.product.renting.common.config.MapstructMapperConfig;
import com.product.renting.order.dto.request.CreateInventoryItemRequest;
import com.product.renting.order.dto.request.UpdateInventoryItemRequest;
import com.product.renting.order.dto.response.InventoryItemResponse;
import com.product.renting.order.entity.InventoryItem;
import org.mapstruct.*;

@Mapper(config = MapstructMapperConfig.class)
public interface InventoryItemMapper {

    InventoryItem toCreateEntity(CreateInventoryItemRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(
            UpdateInventoryItemRequest request,
            @MappingTarget InventoryItem inventoryItem
    );

    @Mapping(target = "productId", source = "product.productId")
    InventoryItemResponse toResponse(InventoryItem inventoryItem);
}
