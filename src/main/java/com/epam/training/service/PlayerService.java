package com.epam.training.service;

import com.epam.training.domain.Player;
import com.epam.training.repository.PlayerRepository;
import com.epam.training.service.common.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PlayerService extends CrudServiceImpl<Player, String> implements UserDetailsService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return playerRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public void saveNew(Player entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        save(entity);
    }


}
