package com.lsh.api.controller;

import com.lsh.api.model.api.WeatherInput;
import com.lsh.api.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @PostMapping
    public ResponseEntity<?> saveWeather(@RequestBody WeatherInput weatherInput) {
        weatherService.saveWeather(weatherInput);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/search/{nx}/{ny}")
    public ResponseEntity<?> searchWeather(@PathVariable String nx,
                                           @PathVariable String ny) {
        return ResponseEntity.ok(weatherService.searchWeather(nx, ny));
    }
}
