package com.lsh.weatherapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Header {
    private String resultCode;
    private String resultMsg;
}
