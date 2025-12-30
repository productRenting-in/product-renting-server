package com.product.renting.common.controller;

import com.product.renting.common.dto.ApiErrorResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.validation.annotation.Validated;

@Validated
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "400",
                description = "Bad request - Invalid input data",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ApiErrorResponse.class),
                        examples = @ExampleObject(
                                name = "ValidationError",
                                summary = "Validation error example",
                                value = """
                {
                  "timestamp": "2023-10-15T10:30:00",
                  "statusCode": 400,
                  "errorMessage": "Validation failed",
                  "path": "/api/v1/endpoint",
                  "traceId": "abc123",
                  "details": [
                    {
                      "field": "name",
                      "message": "Name cannot be blank"
                    }
                  ]
                }
                """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "404",
                description = "Resource not found",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ApiErrorResponse.class),
                        examples = @ExampleObject(
                                name = "NotFoundError",
                                summary = "Resource not found example",
                                value = """
                {
                  "timestamp": "2023-10-15T10:30:00",
                  "statusCode": 404,
                  "errorMessage": "Resource not found with id: 123",
                  "path": "/api/v1/endpoint/123",
                  "traceId": "abc123"
                }
                """
                        )
                )
        ),
        @ApiResponse(
                responseCode = "500",
                description = "Internal server error - Unexpected system error occurred",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ApiErrorResponse.class),
                        examples = {
                                @ExampleObject(
                                        name = "SystemError",
                                        summary = "General system error",
                                        value = """
                    {
                      "timestamp": "2023-10-15T10:30:00",
                      "statusCode": 500,
                      "errorMessage": "An unexpected error occurred",
                      "path": "/api/v1/endpoint",
                      "traceId": "abc123"
                    }
                    """
                                ),
                                @ExampleObject(
                                        name = "DatabaseError",
                                        summary = "Database connection error",
                                        value = """
                    {
                      "timestamp": "2023-10-15T10:30:00",
                      "statusCode": 500,
                      "errorMessage": "Database connection failed",
                      "path": "/api/v1/endpoint",
                      "traceId": "abc123"
                    }
                    """
                                ),
                                @ExampleObject(
                                        name = "StackOverflowError",
                                        summary = "Stack overflow error",
                                        value = """
                    {
                      "timestamp": "2023-10-15T10:30:00",
                      "statusCode": 500,
                      "errorMessage": "Stack overflow error occurred",
                      "path": "/api/v1/endpoint",
                      "traceId": "abc123"
                    }
                    """
                                )
                        }
                )
        )
})
public interface BaseController {
}

