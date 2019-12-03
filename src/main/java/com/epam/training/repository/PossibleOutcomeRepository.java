package com.epam.training.repository;

import com.epam.training.domain.PossibleOutcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PossibleOutcomeRepository extends JpaRepository<PossibleOutcome, String> {
}
