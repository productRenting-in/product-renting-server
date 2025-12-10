package com.product.renting.common.exception;

import com.product.renting.common.builder.ErrorResponseBuilder;
import com.product.renting.common.constant.ErrorMessageConstants;
import com.product.renting.common.dto.ApiErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

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
}
