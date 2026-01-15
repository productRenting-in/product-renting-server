package com.product.renting.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

/**
 * Enhanced unified error response class for API errors.
 * Provides comprehensive error information including error codes for frontend mapping.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorResponse {
    /**
     * Timestamp of the error occurrence.
     */
    private Instant timestamp;

    /**
     * Request trace ID for debugging and support.
     */
    private String traceId;

    /**
     * HTTP status code of the error.
     */
    private int statusCode;

    /**
     * Human-readable error message.
     */
    private String errorMessage;

    /**
     * Path of the request that caused the error.
     * Useful for identifying which endpoint was accessed.
     */
    private String path;

    /**
     * Detailed error information for validation and field-specific errors.
     */
    private List<ErrorDetails> details;
}
