package com.play.Permier_zone.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayersReposatory extends JpaRepository<Player,String> {
    void deleteByName(String PlayerName);
    Optional<Player> findByName(String name);
}
