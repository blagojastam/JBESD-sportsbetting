package com.epam.training.service;

import com.epam.training.domain.Bet;
import com.epam.training.domain.Player;
import com.epam.training.repository.BetRepository;
import com.epam.training.service.common.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetService extends CrudServiceImpl<Bet, String> {

    @Autowired
    BetRepository betRepository;

    public List<Bet> findAllForPlayer(Player player) {
        return betRepository.findAllByPlayer(player);
    }

}
