package com.gozdesy.service;

import com.gozdesy.dto.request.DoLoginRequestDto;
import com.gozdesy.dto.request.RegisterRequestDto;
import com.gozdesy.repository.IAuthRepository;
import com.gozdesy.repository.entity.Auth;
import com.gozdesy.repository.enums.Role;
import com.gozdesy.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends ServiceManager<Auth, Long> {

    private final IAuthRepository authRepository;

    public AuthService(IAuthRepository authRepository) {
        super(authRepository);
        this.authRepository = authRepository;
    }
    public boolean doLogin(DoLoginRequestDto dto) {
        return authRepository.isExist(dto.getUsername(),
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
        return save(auth);
    }
}
