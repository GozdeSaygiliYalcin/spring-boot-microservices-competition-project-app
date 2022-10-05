package com.gozdesy.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QuestionRequestDto {

    @NotNull
    private Long adminId;
    @NotNull
    private String questionContent;
    @NotNull
    private int duration;
    @NotNull
    private int numberOfOption;
}
