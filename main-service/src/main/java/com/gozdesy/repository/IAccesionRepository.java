package com.gozdesy.repository;

import com.gozdesy.repository.entity.Accession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccesionRepository extends JpaRepository<Accession, Long> {
}
