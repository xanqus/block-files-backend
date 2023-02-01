package com.example.flowpre_assignment.standard.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddDuplicateExtensionException extends RuntimeException{
    ErrorCode errorCode;
}
