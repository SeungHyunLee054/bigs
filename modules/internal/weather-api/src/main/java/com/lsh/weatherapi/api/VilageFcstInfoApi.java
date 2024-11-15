package com.lsh.weatherapi.api;

import com.lsh.weatherapi.model.dto.Body;
import com.lsh.weatherapi.model.dto.Root;
import com.lsh.weatherapi.model.dto.WeatherInput;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class VilageFcstInfoApi {
    private final RestTemplate restTemplate = new RestTemplate();

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
