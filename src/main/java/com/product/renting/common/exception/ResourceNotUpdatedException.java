package com.product.renting.common.exception;

public class ResourceNotUpdatedException extends RuntimeException {

    public ResourceNotUpdatedException() {
        super("Could not update the resource");
    }

    public ResourceNotUpdatedException(String message) {
        super(message);
    }

    public ResourceNotUpdatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
