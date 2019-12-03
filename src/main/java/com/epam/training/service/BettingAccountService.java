package com.epam.training.service;

import com.epam.training.domain.BettingAccount;
import com.epam.training.domain.Player;
import com.epam.training.repository.BettingAccountRepository;
import com.epam.training.service.common.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BettingAccountService extends CrudServiceImpl<BettingAccount, String> {

    @Autowired
    BettingAccountRepository bettingAccountRepository;

    public List<BettingAccount> findAllForPlayer(Player player) {
        return bettingAccountRepository.findAllByOwner(player);
    }
}
