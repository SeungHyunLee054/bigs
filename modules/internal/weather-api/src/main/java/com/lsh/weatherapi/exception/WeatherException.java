package com.lsh.weatherapi.exception;


import com.lsh.weatherdomain.type.WeatherApiErrorType;
import lombok.Getter;

@Getter
public class WeatherException extends CustomException {
    private final WeatherApiErrorType weatherApiErrorType;

    public WeatherException(WeatherApiErrorType weatherApiErrorType) {
        super(weatherApiErrorType.getMessage());
        this.weatherApiErrorType = weatherApiErrorType;
    }
}
