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
public class EditProfileRequestDto {

    @NotNull
    String token;
    String username;
    String firstName;
    String lastName;
    String email;
    String phone;
    String photo;
    String address;
    String about;
}
