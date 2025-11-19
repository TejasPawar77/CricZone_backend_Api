package com.play.Permier_zone.Player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlayerService {
    private final PlayersReposatory playersReposatory;

    @Autowired
    public PlayerService(PlayersReposatory playersReposatory){
        this.playersReposatory = playersReposatory;
    }

    public List<Player> getPlayer(){
        return playersReposatory.findAll();
    }

    public List<Player> getPlayerFromTeam(String teamName){
        return playersReposatory.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam()))
                .collect(Collectors.toList());
    }
    public List<Player> getPlayerByName(String searchText){
        return playersReposatory.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }
    public Player addPlayer(Player player){
        playersReposatory.save(player);
        return player;
    }
    public Player updatePlayer(Player updatePlayer){
        Optional<Player> existingPlayer = playersReposatory.findByName(updatePlayer.getName());

        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setImg(updatePlayer.getImg());
            playerToUpdate.setName(updatePlayer.getName());
            playerToUpdate.setTeam(updatePlayer.getTeam());
            playerToUpdate.setPos(updatePlayer.getPos());
            playerToUpdate.setNation(updatePlayer.getNation());

            playersReposatory.save(playerToUpdate);
            return  playerToUpdate;
        }
        return null;
    }
    @Transactional
    public void deletePlayer(String playerName){
        playersReposatory.deleteByName(playerName);
    }
}
