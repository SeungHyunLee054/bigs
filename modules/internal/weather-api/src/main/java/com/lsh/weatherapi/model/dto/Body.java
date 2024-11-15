package com.lsh.weatherapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Body {
    private String dataType;
    private Items items;
    private String pageNo;
    private String numOfRows;
    private String totalCount;
}
