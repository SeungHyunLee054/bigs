package com.lsh.api.exception;

import com.lsh.api.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.lsh.domain.type.ApiErrorType.DATA_NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(WeatherException.class)
    public ResponseEntity<?> weatherExceptionHandler(WeatherException e) {
        if (e.getErrorType() == DATA_NOT_FOUND) {
            return ResponseEntity.status(204).body(
                    new ErrorResponse(HttpStatus.NO_CONTENT.value(), e.getMessage())
            );
        }

        return ResponseEntity.internalServerError().body(
                new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage())
        );
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> customExceptionHandler(CustomException e) {
        return ResponseEntity.internalServerError().body(
                new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage())
        );
    }
}
