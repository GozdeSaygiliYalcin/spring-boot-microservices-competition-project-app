package com.gozdesy.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QuestionRequestDto {

    private String token;
    private Long adminId;
    private String questionContent;
    private int duration;
    private int numberOfOption;
}
