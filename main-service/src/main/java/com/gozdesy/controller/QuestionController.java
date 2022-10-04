package com.gozdesy.controller;

import com.gozdesy.dto.request.CreatingQuestionRequestDto;
import com.gozdesy.dto.request.QuestionRequestDto;
import com.gozdesy.exception.ErrorType;
import com.gozdesy.exception.MainServiceException;
import com.gozdesy.service.QuestionService;
import com.gozdesy.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

import static com.gozdesy.constant.ApiUrl.*;

@RestController
@RequestMapping(BASE_URL+MAIN+QUESTION)
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;
    private final JwtTokenManager jwtTokenManager;

    @PostMapping(CREATE)
    public ResponseEntity<Void> createQuestion(@RequestBody @Valid CreatingQuestionRequestDto dto) {
        try {
            Optional<Long> userId = jwtTokenManager.getUserId(dto.getToken());
            if(userId.isEmpty())
                throw new MainServiceException(ErrorType.INVALID_TOKEN);
                questionService.addQuestion(dto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new MainServiceException(ErrorType.INVALID_TOKEN);
        }
    }
}
