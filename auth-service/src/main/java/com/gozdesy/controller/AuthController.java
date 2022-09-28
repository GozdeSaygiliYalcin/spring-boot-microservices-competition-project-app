package com.gozdesy.controller;

import com.gozdesy.dto.request.DoLoginRequestDto;
import com.gozdesy.dto.request.RegisterRequestDto;
import com.gozdesy.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.gozdesy.constant.ApiUrl.*;

@RestController
@RequestMapping(BASE_URL+AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(LOGIN)
    public ResponseEntity<String> doLogin(DoLoginRequestDto dto) {
        if(authService.doLogin(dto))
            return ResponseEntity.ok("Giriş Başarılı");
        return ResponseEntity.badRequest().body("Giriş Başarısız");
    }
    @GetMapping(REGISTER)
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequestDto dto) {
        authService.register(dto);
        return ResponseEntity.ok().build();
    }
}
