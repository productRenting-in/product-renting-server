package com.product.renting.order.controller;

import com.product.renting.common.constant.ApiEndPoints;
import com.product.renting.order.dto.request.CategoryRequest;
import com.product.renting.order.dto.response.CategoryResponse;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@Tag(name = "Category Management", description = "APIs for managing Category")
@RequestMapping(ApiEndPoints.CATEGORY_V1)
public interface CategoryController {

    @Operation(summary = "Create a new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category created successfully",
                    content = @Content(schema = @Schema(implementation = CategoryResponse.class)))
    })
    @PostMapping
    ResponseEntity<CategoryResponse> addCategory(@RequestBody @Valid CategoryRequest categoryRequest);
}
