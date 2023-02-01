package com.example.flowpre_assignment.standard.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    DEFAULT_EXTENSION_ERROR(HttpStatus.BAD_REQUEST, "기본 확장자는 추가할 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
