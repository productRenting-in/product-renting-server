package com.product.renting.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Detailed error information for validation and field-specific errors.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    /**
     * Field name for validation errors (e.g., "materialName", "email")
     */
    private String field;

    /**
     * Human-readable error message for this field
     */
    private String message;
}

