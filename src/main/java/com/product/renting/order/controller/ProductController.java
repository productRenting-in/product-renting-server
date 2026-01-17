package com.product.renting.order.controller;

import com.product.renting.common.constant.ApiEndPoints;
import com.product.renting.common.controller.BaseController;
import com.product.renting.order.dto.request.ProductRequest;
import com.product.renting.order.dto.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
@Tag(name = "Product Management", description = "APIs for managing Product")
@RequestMapping(ApiEndPoints.PRODUCT_V1)
public interface ProductController extends BaseController {

    @Operation(summary = "Get all Products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products found",
                    content = @Content(schema = @Schema(implementation = ProductResponse.class)))
    })
    @GetMapping("/all")
    ResponseEntity<List<ProductResponse>> getAll();

    @Operation(summary = "Get all Products By Category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products found by category",
                    content = @Content(schema = @Schema(implementation = ProductResponse.class)))
    })
    @GetMapping
    ResponseEntity<List<ProductResponse>> getProductsByCategory(@RequestParam(value = "categoryId") @NotNull UUID categoryId);

    @Operation(summary = "Create a new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product created successfully",
                    content = @Content(schema = @Schema(implementation = ProductResponse.class)))
    })
    @PostMapping
    ResponseEntity<ProductResponse> addProduct(
            @RequestBody @Valid ProductRequest productRequest
    );
}
