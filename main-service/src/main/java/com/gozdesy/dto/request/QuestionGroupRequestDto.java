package com.gozdesy.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class QuestionGroupRequestDto {
    @NotNull
    @Size(min = 16)
    private String token;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 3)
    private String groupName;
}
