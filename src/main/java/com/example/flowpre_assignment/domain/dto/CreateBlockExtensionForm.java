package com.example.flowpre_assignment.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateBlockExtensionForm {

    @NotNull(message = "확장자의 값이 존재해야 합니다.")
    @Size(min = 1, max = 20, message = "확장자의 길이는 1글자에서 20글자 사이여야 합니다.")
    private String extensionKeyword;
}
