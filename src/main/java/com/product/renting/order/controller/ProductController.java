package com.product.renting.order.controller;

import com.product.renting.common.constant.ApiEndPoints;
import com.product.renting.common.controller.BaseController;
import com.product.renting.order.dto.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Validated
@Tag(name = "Product Management", description = "APIs for managing Product")
@RequestMapping(ApiEndPoints.PRODUCT_V1)
public interface ProductController extends BaseController {

    @Operation(summary = "Get all Products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products found",
                    content = @Content(schema = @Schema(implementation = ProductResponse.class)))
    })
    @GetMapping
    ResponseEntity<List<ProductResponse>> getAll();
}
