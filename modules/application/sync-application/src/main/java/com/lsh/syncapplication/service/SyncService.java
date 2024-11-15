package com.lsh.syncapplication.service;


import com.lsh.weatherapi.api.VilageFcstInfoApi;
import com.lsh.weatherapi.model.dto.WeatherDto;
import com.lsh.weatherapi.model.dto.WeatherInput;
import com.lsh.weatherdomain.entity.Weather;
import com.lsh.weatherdomain.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SyncService {
    private final WeatherRepository weatherRepository;
    private final VilageFcstInfoApi vilageFcstInfoApi;

    public void saveWeather(WeatherInput weatherInput) {
        int totalCnt = vilageFcstInfoApi.getTotalPage(weatherInput);
        int pageEnd = totalCnt / Integer.parseInt(weatherInput.getNumOfRows());
        for (int i = 1; i <= pageEnd; i++) {
            String curPage = String.valueOf(i);
            List<Weather> weatherList =
                    vilageFcstInfoApi.getWeather(weatherInput, curPage).getItems().getItem().stream()
                            .map(WeatherDto::from)
                            .toList();

            weatherRepository.saveAll(weatherList);
        }

        log.info("{}개 예보 저장", totalCnt);
    }
}
