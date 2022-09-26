package com.gozdesy.dto.request;

import com.gozdesy.repository.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterRequestDto {

    @NotNull(message = "Boş bırakılamaz")
    @Size(min = 3, max = 20, message = "Kullanıcı adı en az 3 karakter ve en fazla 20 karakter olabilir")
    String username;
    @NotNull(message = "Boş bırakılamaz")
    String password;
    @NotNull(message = "Boş bırakılamaz")
    @Email(message = "Email formatı uygun değil")
    String email;
    Role role;
    String RoleAdminPassword;
}
