package com.product.renting.common.exception;

public class ResourceNotCreatedException extends RuntimeException {

    public ResourceNotCreatedException() {
        super("Could not create resource");
    }

    public ResourceNotCreatedException(String message) {
        super(message);
    }

    public ResourceNotCreatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
