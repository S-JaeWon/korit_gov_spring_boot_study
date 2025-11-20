package com.korit.korit_gov_spring_boot_study.dto.Respone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PostRespDto<T> {
    private String status;
    private String message;
    private T data;
}
