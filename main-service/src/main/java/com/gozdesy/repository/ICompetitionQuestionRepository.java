package com.gozdesy.repository;

import com.gozdesy.repository.entity.CompetitionQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompetitionQuestionRepository extends JpaRepository<CompetitionQuestion, Long> {
}
