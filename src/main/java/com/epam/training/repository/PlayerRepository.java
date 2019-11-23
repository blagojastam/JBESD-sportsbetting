package com.epam.training.repository;

import com.epam.training.domain.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
    Optional<Player> findByEmail(String email);
}
