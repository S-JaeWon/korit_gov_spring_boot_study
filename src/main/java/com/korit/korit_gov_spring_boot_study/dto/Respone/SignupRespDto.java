package com.korit.korit_gov_spring_boot_study.dto.Respone;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignupRespDto {
    private String status;
    private String message;
}
