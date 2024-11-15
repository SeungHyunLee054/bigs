package com.lsh.api.service;

import com.lsh.api.exception.WeatherException;
import com.lsh.api.model.api.WeatherInput;
import com.lsh.api.model.dto.WeatherDto;
import com.lsh.domain.entity.Weather;
import com.lsh.domain.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.lsh.domain.type.ApiErrorType.DATA_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class WeatherService {
    private final WeatherRepository weatherRepository;
    private final VilageFcstInfoService vilageFcstInfoService;

    public void saveWeather(WeatherInput weatherInput) {
        int totalCnt = vilageFcstInfoService.getTotalPage(weatherInput);
        int pageEnd = totalCnt / Integer.parseInt(weatherInput.getNumOfRows());
        for (int i = 1; i <= pageEnd; i++) {
            String curPage = String.valueOf(i);
            List<Weather> weatherList =
                    vilageFcstInfoService.getWeather(weatherInput, curPage).getItems().getItem().stream()
                            .map(WeatherDto::from)
                            .toList();

            weatherRepository.saveAll(weatherList);
        }

        log.info("{}개 예보 저장", totalCnt);
    }

    public List<WeatherDto> searchWeather(String nx, String ny) {
        List<WeatherDto> weatherDtoList =
                weatherRepository.findAllByNxAndNy(nx, ny).stream()
                        .map(WeatherDto::of)
                        .toList();

        validateWeatherList(weatherDtoList);

        return weatherDtoList;
    }

    private static void validateWeatherList(List<WeatherDto> weatherDtoList) {
        if (weatherDtoList.isEmpty()) {
            throw new WeatherException(DATA_NOT_FOUND);
        }
    }

}
