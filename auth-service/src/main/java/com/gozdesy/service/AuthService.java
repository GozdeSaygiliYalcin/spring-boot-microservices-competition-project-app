package com.gozdesy.service;

import com.gozdesy.dto.request.DoLoginRequestDto;
import com.gozdesy.dto.request.NewUserCreateDto;
import com.gozdesy.dto.request.RegisterRequestDto;
import com.gozdesy.manager.IUserManager;
import com.gozdesy.repository.IAuthRepository;
import com.gozdesy.repository.entity.Auth;
import com.gozdesy.repository.enums.Role;
import com.gozdesy.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth, Long> {

    private final IAuthRepository authRepository;
    private final IUserManager userManager;

    public AuthService(IAuthRepository authRepository, IUserManager userManager) {
        super(authRepository);
        this.authRepository = authRepository;
        this.userManager = userManager;
    }

    /**
     * nasıl bir metot
     * @param dto
     * @return
     */
    public Optional<Auth> doLogin(DoLoginRequestDto dto) {
        return authRepository.findOptionalByUsernameIgnoreCaseAndPassword(dto.getUsername(),
        dto.getPassword());
    }

    public Auth register(RegisterRequestDto dto){
        Auth auth;
        auth = Auth.builder()
                .password(dto.getPassword())
                .username(dto.getUsername())
                .build();
        if(dto.getRoleAdminPassword()!=null)
            if(dto.getRoleAdminPassword().equals("123456"))
                auth.setRole(dto.getRole()==null ? Role.ADMIN : dto.getRole());
            else
                auth.setRole(Role.USER);
        save(auth);
        userManager.NewUserCreate(
                NewUserCreateDto.builder()
                        .authId(auth.getId())
                        .email(dto.getEmail())
                        .username(dto.getUsername())
                        .build()
        );
        return auth;
    }
}
