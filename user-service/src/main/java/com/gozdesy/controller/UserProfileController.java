package com.gozdesy.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.gozdesy.dto.request.EditProfileRequestDto;
import com.gozdesy.dto.request.NewUserCreateDto;
import com.gozdesy.exception.ErrorType;
import com.gozdesy.exception.UserManagerException;
import com.gozdesy.service.UserProfileService;
import com.gozdesy.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.Date;
import java.util.Optional;

import static com.gozdesy.constant.ApiUrl.*;

@RestController
@RequiredArgsConstructor // bunu neden koymamız gerekiyor
@RequestMapping(BASE_URL+USER)
public class UserProfileController {

    private final UserProfileService userProfileService;
    private final JwtTokenManager jwtTokenManager;

    @PostMapping(NEW_CREATE_USER)
    public ResponseEntity<Boolean> newUserCreate(@RequestBody @Valid NewUserCreateDto dto) {
        try {
            userProfileService.createUserProfile(dto);
            return ResponseEntity.ok(true);
        } catch (Exception exception) {
            throw new UserManagerException(ErrorType.USER_DOESNT_CREATED);
        }
    }
    @PostMapping(UPDATE_PROFILE)
    public ResponseEntity<Boolean> updateProfile(@RequestBody @Valid EditProfileRequestDto dto) {

        try {
            Optional<Long> authId = jwtTokenManager.getUserId(dto.getToken());
           if(authId.isEmpty())
               throw new UserManagerException(ErrorType.INVALID_TOKEN);
            return ResponseEntity.ok(userProfileService.updateUserProfile(dto, authId.get()));
        } catch (Exception exception) {
            throw new UserManagerException((ErrorType.INVALID_TOKEN));
        }
    }
}
