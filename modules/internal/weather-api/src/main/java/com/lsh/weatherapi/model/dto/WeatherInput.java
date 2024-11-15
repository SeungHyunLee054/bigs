package com.lsh.weatherapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherInput {
    private String numOfRows;
    private String dataType = "JSON";
    private String base_date;
    private String base_time;
    private String nx;
    private String ny;
}
