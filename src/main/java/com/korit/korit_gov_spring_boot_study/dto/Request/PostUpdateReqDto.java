package com.korit.korit_gov_spring_boot_study.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostUpdateReqDto {
    private Integer postId;
    private String content;
}
