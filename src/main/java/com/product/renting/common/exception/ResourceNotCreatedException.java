package com.product.renting.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

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
