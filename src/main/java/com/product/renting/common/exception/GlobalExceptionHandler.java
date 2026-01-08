package com.product.renting.common.exception;

import com.product.renting.common.builder.ErrorResponseBuilder;
import com.product.renting.common.constant.ErrorMessageConstants;
import com.product.renting.common.dto.ApiErrorResponse;
import com.product.renting.common.dto.ErrorDetails;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private void setupMDC() {
        if (MDC.get("requestId") == null) {
            MDC.put("requestId", UUID.randomUUID().toString());
        }
    }

    /**
     * Generic exception handler
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGenericException(Exception ex, WebRequest request) {
        setupMDC();
        log.error("UNHANDLED_EXCEPTION : ", ex);

        ApiErrorResponse errorResponse = ErrorResponseBuilder.createErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessageConstants.GENERIC_SERVER_ERROR_MESSAGE, request);

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handle ResourceNotCreatedException
     */
    @ExceptionHandler(ResourceNotCreatedException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotCreatedException(
            ResourceNotCreatedException ex,
            WebRequest request) {

        setupMDC();
        log.error("RESOURCE_NOT_CREATED : {}", ex.getMessage(), ex);

        ApiErrorResponse errorResponse = ErrorResponseBuilder.createErrorResponse(
                HttpStatus.BAD_REQUEST,
                ex.getMessage() != null
                        ? ex.getMessage()
                        : ErrorMessageConstants.RESOURCE_NOT_CREATED,
                request
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle ResourceNotFoundException
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFoundException(
            ResourceNotFoundException ex,
            WebRequest request) {

        setupMDC();
        log.error("RESOURCE_NOT_FOUND : {}", ex.getMessage(), ex);

        ApiErrorResponse errorResponse = ErrorResponseBuilder.createErrorResponse(
                HttpStatus.BAD_REQUEST,
                ex.getMessage() != null
                        ? ex.getMessage()
                        : ErrorMessageConstants.RESOURCE_NOT_FOUND,
                request
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle ResourceNotUpdatedException
     */
    @ExceptionHandler(ResourceNotUpdatedException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotUpdatedException(
            ResourceNotUpdatedException ex,
            WebRequest request) {

        setupMDC();
        log.error("RESOURCE_NOT_UPDATED : {}", ex.getMessage(), ex);

        ApiErrorResponse errorResponse = ErrorResponseBuilder.createErrorResponse(
                HttpStatus.BAD_REQUEST,
                ex.getMessage() != null
                        ? ex.getMessage()
                        : ErrorMessageConstants.RESOURCE_NOT_UPDATED,
                request
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle DuplicateResourceException
     */
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiErrorResponse> handleDuplicateResourceException(
            DuplicateResourceException ex,
            WebRequest request) {

        setupMDC();
        log.error("DUPLICATE_RESOURCE : {}", ex.getMessage(), ex);

        ApiErrorResponse errorResponse = ErrorResponseBuilder.createErrorResponse(
                HttpStatus.CONFLICT, // 409 is best for duplicate/uniqueness violations
                ex.getMessage() != null
                        ? ex.getMessage()
                        : "Resource already exists",
                request
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    /**
     * Handle method argument validation errors.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        setupMDC();
        log.error("Method argument validation failed: {}", ex.getMessage());

        List<ErrorDetails> details = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            if (error instanceof FieldError fieldError) {
                details.add(ErrorDetails.builder().field(fieldError.getField()).message(fieldError.getDefaultMessage()).build());
            } else {
                details.add(ErrorDetails.builder().field("object").message(error.getDefaultMessage()).build());
            }
        });

        ApiErrorResponse response = ErrorResponseBuilder.createValidationErrorResponse(
                ErrorMessageConstants.VALIDATION_ERROR_MESSAGE, details, request);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
