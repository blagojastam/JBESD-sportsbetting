package com.epam.training.service;

import com.epam.training.domain.Player;
import com.epam.training.repository.PlayerRepository;
import com.epam.training.service.common.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService extends CrudServiceImpl<Player, Integer> {

    @Autowired
    PlayerRepository playerRepository;

    public Optional<Player> findByEmail(String email){
        return playerRepository.findByEmail(email);
    }
}
