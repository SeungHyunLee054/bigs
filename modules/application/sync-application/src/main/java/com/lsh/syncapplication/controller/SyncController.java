package com.lsh.syncapplication.controller;

import com.lsh.syncapplication.service.SyncService;
import com.lsh.weatherapi.model.dto.WeatherInput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class SyncController {
    private final SyncService syncService;

    @PostMapping("/sync")
    public ResponseEntity<?> saveWeather(@RequestBody WeatherInput weatherInput) {
        syncService.saveWeather(weatherInput);

        return ResponseEntity.ok().build();
    }
}
