package com.gozdesy.repository;

import com.gozdesy.repository.entity.Scanning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScanningRepository extends JpaRepository<Scanning, Long> {
}
