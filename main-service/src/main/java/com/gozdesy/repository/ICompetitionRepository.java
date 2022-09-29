package com.gozdesy.repository;

import com.gozdesy.repository.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompetitionRepository extends JpaRepository<Competition, Long> {
}
