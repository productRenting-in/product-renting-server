package com.product.renting.order.controller;

import com.product.renting.common.constant.ApiEndPoints;
import com.product.renting.order.dto.request.CreateInventoryItemRequest;
import com.product.renting.order.dto.request.UpdateInventoryItemRequest;
import com.product.renting.order.dto.response.InventoryItemResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@Tag(name = "Inventory Item management", description = "APIs for managing Inventory Item")
@RequestMapping(ApiEndPoints.INVENTORY_ITEM_V1)
public interface InventoryItemController {

    @Operation(summary = "Create a new inventory item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Inventory item created successfully",
                    content = @Content(schema = @Schema(implementation = InventoryItemResponse.class)))
    })
    @PostMapping
    ResponseEntity<InventoryItemResponse> create(
            @RequestBody @Valid CreateInventoryItemRequest request
    );

    @Operation(summary = "Update an inventory item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Inventory item updated successfully",
                    content = @Content(schema = @Schema(implementation = InventoryItemResponse.class)))
    })
    @PutMapping
    ResponseEntity<InventoryItemResponse> update(
            @RequestBody @Valid UpdateInventoryItemRequest request
    );
}
