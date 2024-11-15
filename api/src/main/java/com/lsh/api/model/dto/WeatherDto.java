package com.lsh.api.model.dto;

import com.lsh.domain.entity.Weather;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherDto {
    private String baseDate;
    private String baseTime;
    private String category;
    private String fcstDate;
    private String fcstTime;
    private String fcstValue;
    private String nx;
    private String ny;

    public static WeatherDto of(Weather weather) {
        return WeatherDto.builder()
                .baseDate(weather.getBaseDate())
                .baseTime(weather.getBaseTime())
                .fcstDate(weather.getFcstDate())
                .fcstTime(weather.getFcstTime())
                .category(weather.getCategory())
                .nx(weather.getNx())
                .ny(weather.getNy())
                .build();
    }

    public static Weather from(WeatherDto weatherDto) {
        return Weather.builder()
                .baseDate(weatherDto.baseDate)
                .baseTime(weatherDto.baseTime)
                .category(weatherDto.category)
                .fcstDate(weatherDto.fcstDate)
                .fcstTime(weatherDto.fcstTime)
                .fcstValue(weatherDto.fcstValue)
                .nx(weatherDto.nx)
                .ny(weatherDto.ny)
                .build();
    }
}
