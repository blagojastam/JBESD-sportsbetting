package com.epam.training.repository;

import com.epam.training.domain.BettingAccount;
import com.epam.training.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BettingAccountRepository extends JpaRepository<BettingAccount, String> {
    List<BettingAccount> findAllByOwner(Player owner);
}
