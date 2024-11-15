package com.lsh.api.exception;

import com.lsh.domain.type.ApiErrorType;
import lombok.Getter;

@Getter
public class WeatherException extends CustomException {
    private final ApiErrorType errorType;

    public WeatherException(ApiErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
}
