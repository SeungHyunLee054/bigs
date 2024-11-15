package com.lsh.inquireapplication.service;


import com.lsh.weatherapi.exception.WeatherException;
import com.lsh.weatherapi.model.dto.WeatherDto;
import com.lsh.weatherdomain.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.lsh.weatherdomain.type.WeatherApiErrorType.DATA_NOT_FOUND;


@Service
@RequiredArgsConstructor
@Slf4j
public class InquireService {
    private final WeatherRepository weatherRepository;

    public List<WeatherDto> searchWeather(String nx, String ny) {
        List<WeatherDto> weatherDtoList =
                weatherRepository.findAllByNxAndNy(nx, ny).stream()
                        .map(WeatherDto::of)
                        .toList();

        validateWeatherList(weatherDtoList);

        log.info("{}개의 예보 조회", weatherDtoList.size());
        return weatherDtoList;
    }

    private static void validateWeatherList(List<WeatherDto> weatherDtoList) {
        if (weatherDtoList.isEmpty()) {
            throw new WeatherException(DATA_NOT_FOUND);
        }
    }

}
