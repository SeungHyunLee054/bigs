package com.lsh.api.model.response;

import com.lsh.api.model.dto.WeatherDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Items {
    private List<WeatherDto> item;
}
