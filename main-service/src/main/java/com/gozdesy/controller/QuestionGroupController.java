package com.gozdesy.controller;

import com.gozdesy.dto.request.QuestionGroupRequestDto;
import com.gozdesy.exception.ErrorType;
import com.gozdesy.exception.MainServiceException;
import com.gozdesy.repository.entity.QuestionGroup;
import com.gozdesy.service.QuestionGroupService;
import com.gozdesy.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.gozdesy.constant.ApiUrl.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(BASE_URL+MAIN+QUESTION_GROUP)
public class QuestionGroupController {

    private final JwtTokenManager jwtTokenManager;
    private final QuestionGroupService questionGroupService;

    @PostMapping(CREATE_QUESTION_GROUP)
    public ResponseEntity<QuestionGroup> crateQuestionGroup(@RequestBody @Valid QuestionGroupRequestDto dto) {
        try {
            Optional<Long> userId = jwtTokenManager.getUserId(dto.getToken());
            if (userId.isEmpty())
            /**
             * bize gelen user id'nin bu işlemi yapacak
             * yetkisi olup olmadığı kontrol edilerek işleme
             * izin verilmelidir.
             */
                throw new MainServiceException(ErrorType.INVALID_TOKEN);
            return ResponseEntity.ok(questionGroupService.save(QuestionGroup.builder()
                    .groupName(dto.getGroupName())
                    .build()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
