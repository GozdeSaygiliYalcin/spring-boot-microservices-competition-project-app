package com.gozdesy.service;

import com.gozdesy.repository.IAuthRepository;
import com.gozdesy.repository.entity.Auth;
import com.gozdesy.utility.ServiceManager;

public class AuthService extends ServiceManager<Auth, Long> {

    private final IAuthRepository authRepository;

    public AuthService(IAuthRepository authRepository) {
        super(authRepository);
        this.authRepository = authRepository;
    }
}
