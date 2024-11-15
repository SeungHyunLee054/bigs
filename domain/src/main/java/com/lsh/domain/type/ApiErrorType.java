package com.lsh.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiErrorType {
    DATA_NOT_FOUND("데이터가 존재하지 않습니다.")
    ;

    private final String message;
}
