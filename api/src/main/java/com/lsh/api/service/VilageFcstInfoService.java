package com.lsh.api.service;

import com.lsh.api.model.api.WeatherInput;
import com.lsh.api.model.response.Body;
import com.lsh.api.model.response.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class VilageFcstInfoService {
    private final RestTemplate restTemplate;

    @Value("${api.service-key}")
    private String serviceKey;
    @Value("${api.service-url}")
    private String serviceUrl;

    public Body getWeather(WeatherInput weatherInput, String pageNo) {
        String url = serviceUrl + "?serviceKey=" + serviceKey
                + "&pageNo=" + pageNo
                + "&numOfRows=" + weatherInput.getNumOfRows()
                + "&dataType=" + weatherInput.getDataType()
                + "&base_date=" + weatherInput.getBase_date()
                + "&base_time=" + weatherInput.getBase_time()
                + "&nx=" + weatherInput.getNx()
                + "&ny=" + weatherInput.getNy();

        URI apiUri;
        try {
            apiUri = new URI(url);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return Objects.requireNonNull(restTemplate.getForObject(apiUri, Root.class)).getResponse().getBody();
    }

    public int getTotalPage(WeatherInput weatherInput) {
        return Integer.parseInt(getWeather(weatherInput, "1").getTotalCount());
    }
}
