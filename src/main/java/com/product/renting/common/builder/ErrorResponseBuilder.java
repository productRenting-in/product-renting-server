package com.product.renting.common.builder;

import com.product.renting.common.dto.ApiErrorResponse;
import com.product.renting.common.dto.ErrorDetails;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponseBuilder {

    private ErrorResponseBuilder() {
        // Utility class
    }

    /**
     * Creates a basic error response with standard HTTP status code.
     */
    public static ApiErrorResponse.ApiErrorResponseBuilder createBasicErrorResponse(
            HttpStatus httpStatus, String message, WebRequest request) {
        return ApiErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(httpStatus.value())
                .errorMessage(message)
                .traceId(MDC.get("requestId"))
                .path(getRequestPath(request));
    }

    /**
     * Creates an error response for business exceptions.
     */
    public static ApiErrorResponse createErrorResponse(
            HttpStatus httpStatus, String message, WebRequest request) {
        return createBasicErrorResponse(httpStatus, message, request)
                .build();
    }

    /**
     * Creates an error response for validation errors with field details.
     */
    public static ApiErrorResponse createValidationErrorResponse(
            String message, List<ErrorDetails> details, WebRequest request) {
        return createBasicErrorResponse(HttpStatus.BAD_REQUEST, message, request)
                .details(details)
                .build();
    }

    /**
     * Extracts request path from WebRequest.
     */
    private static String getRequestPath(WebRequest request) {
        return request != null ? request.getDescription(false) : "unknown";
    }
}
