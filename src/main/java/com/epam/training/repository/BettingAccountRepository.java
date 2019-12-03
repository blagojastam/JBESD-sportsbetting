package com.epam.training.repository;

import com.epam.training.domain.BettingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BettingAccountRepository extends JpaRepository<BettingAccount, String> {
}
