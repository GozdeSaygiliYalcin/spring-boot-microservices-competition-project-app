package com.gozdesy.service;

import com.gozdesy.dto.request.CompetitionQuestionRequestDto;
import com.gozdesy.mapper.ICompetitionQuestionMapper;
import com.gozdesy.repository.ICompetitionQuestionRepository;
import com.gozdesy.repository.entity.CompetitionQuestion;
import com.gozdesy.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CompetitionQuestionService extends ServiceManager<CompetitionQuestion, Long> {

    private final ICompetitionQuestionRepository competitionQuestionRepository;

    public CompetitionQuestionService(ICompetitionQuestionRepository competitionQuestionRepository) {
        super(competitionQuestionRepository);
        this.competitionQuestionRepository = competitionQuestionRepository;
    }

    public CompetitionQuestion save(CompetitionQuestionRequestDto dto) {
        return save(ICompetitionQuestionMapper.INSTANCE.toCompetitionQuestion(dto));
    }
}
