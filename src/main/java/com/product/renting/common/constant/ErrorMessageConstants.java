package com.product.renting.common.constant;

public class ErrorMessageConstants {
    private ErrorMessageConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    // Generic Error Messages
    public static final String GENERIC_ERROR_MESSAGE = "Something went wrong. Please try again later.";
    public static final String GENERIC_SERVER_ERROR_MESSAGE = "Something went wrong on our end. Please try again later.";
    public static final String RESOURCE_NOT_CREATED = "Resource could not be created";
    public static final String RESOURCE_NOT_FOUND = "Could not find resource";
    public static final String RESOURCE_NOT_UPDATED = "Resource could not be updated";
    public static final String VALIDATION_ERROR_MESSAGE = "The provided value is invalid or of a different type than expected";
}
