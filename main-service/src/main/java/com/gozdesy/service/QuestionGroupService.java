package com.gozdesy.service;

import com.gozdesy.repository.IQuestionGroupRepository;
import com.gozdesy.repository.entity.QuestionGroup;
import com.gozdesy.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class QuestionGroupService extends ServiceManager<QuestionGroup, Long> {

    private final IQuestionGroupRepository questionGroupRepository;

    public QuestionGroupService(IQuestionGroupRepository questionGroupRepository) {
        super(questionGroupRepository);
        this.questionGroupRepository = questionGroupRepository;
    }
}
