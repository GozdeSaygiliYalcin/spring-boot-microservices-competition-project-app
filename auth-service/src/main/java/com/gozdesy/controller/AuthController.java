package com.gozdesy.controller;

import com.gozdesy.dto.request.DoLoginRequestDto;
import com.gozdesy.dto.request.RegisterRequestDto;
import com.gozdesy.repository.entity.Auth;
import com.gozdesy.service.AuthService;
import com.gozdesy.config.security.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Optional;

import static com.gozdesy.constant.ApiUrl.*;

@RestController
@RequestMapping(BASE_URL+AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtTokenManager jwtTokenManager;

    @GetMapping("/test")
    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public String getTestString() {
        return "Auth test";
    }
    @PostMapping(LOGIN)
    public ResponseEntity<String> doLogin(@RequestBody @Valid DoLoginRequestDto dto){
        Optional<Auth> auth = authService.doLogin(dto);
        if(auth.isPresent()) {
            String token = jwtTokenManager.createToken(auth.get().getId()).get();
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().body("Giriş Başarısız");
    }
    @PostMapping (REGISTER)
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequestDto dto) {
        authService.register(dto);
        return ResponseEntity.ok().build();
    }
}
