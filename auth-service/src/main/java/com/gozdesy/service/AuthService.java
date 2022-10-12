package com.gozdesy.service;

import com.gozdesy.dto.request.DoLoginRequestDto;
import com.gozdesy.dto.request.NewUserCreateDto;
import com.gozdesy.dto.request.RegisterRequestDto;
import com.gozdesy.manager.IUserManager;
import com.gozdesy.rabbitmq.model.CreateUser;
import com.gozdesy.rabbitmq.producer.CreateUserProducer;
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

    private final CreateUserProducer userProducer;

    public AuthService(IAuthRepository authRepository, IUserManager userManager, CreateUserProducer userProducer) {
        super(authRepository);
        this.authRepository = authRepository;
        this.userManager = userManager;
        this.userProducer = userProducer;
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
        userProducer.sendCreateUserMessage(CreateUser.builder()
                .authId(auth.getId())
                .email(dto.getEmail())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build());
        return auth;
    }
}
