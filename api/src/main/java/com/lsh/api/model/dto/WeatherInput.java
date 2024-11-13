package com.lsh.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherInput {
    private int pageNo;
    private int numOfRows;
    private String dataType = "JSON";
    private int base_time;
    private int nx;
    private int ny;
}
