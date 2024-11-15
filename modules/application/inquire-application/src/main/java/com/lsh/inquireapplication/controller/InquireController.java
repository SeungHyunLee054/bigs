package com.lsh.inquireapplication.controller;

import com.lsh.inquireapplication.service.InquireService;
import com.lsh.weatherapi.model.dto.WeatherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class InquireController {
    private final InquireService inquireService;

    @GetMapping("/search/{nx}/{ny}")
    public ResponseEntity<List<WeatherDto>> searchWeather(@PathVariable String nx,
                                                          @PathVariable String ny) {
        return ResponseEntity.ok(inquireService.searchWeather(nx, ny));
    }
}
