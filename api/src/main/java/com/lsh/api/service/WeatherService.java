package com.lsh.api.service;

import com.lsh.api.model.dto.WeatherInput;
import com.lsh.domain.entity.Weather;
import com.lsh.domain.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final RestTemplate restTemplate;
    @Value("${ServiceKey}")
    private  String ServiceKey;

    private final WeatherRepository weatherRepository;
    private String ServiceUrl="http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0";

    public void saveWeather(WeatherInput weatherInput) {
        int totalPage;
        String base_date= LocalDate.now().toString();
    }
}
