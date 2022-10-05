package com.gozdesy.service;

import com.gozdesy.dto.request.CompetitionRequestDto;
import com.gozdesy.mapper.ICompetitionMapper;
import com.gozdesy.repository.ICompetitionRepository;
import com.gozdesy.repository.entity.Competition;
import com.gozdesy.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CompetitionService extends ServiceManager<Competition, Long> {
    private final ICompetitionRepository competitionRepository;

    public CompetitionService(ICompetitionRepository competitionRepository) {
        super(competitionRepository);
        this.competitionRepository = competitionRepository;
    }

    public Competition save(CompetitionRequestDto dto) {

        return save(ICompetitionMapper.INSTANCE.toCompetition(dto));
    }
}
