package com.epam.training.config;

import com.epam.training.domain.Player;
import com.epam.training.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;

public class Initializer {

    @Autowired
    PlayerService playerService;

    public void initPlayer(){
        Player player = new Player();
        player.setPassword("password");
        playerService.saveNew(player);

        player.setUsername("baki");
        player.setEnabled(true);
        playerService.save(player);
    }
}
