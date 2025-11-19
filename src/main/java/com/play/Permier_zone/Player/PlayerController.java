package com.play.Permier_zone.Player;

import com.play.Permier_zone.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping(path = "api/v1/player")
public class PlayerController {
    private final PlayerService playerService;
    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(
        @RequestParam(required = false) String team,
        @RequestParam(required = false) String nation,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String pos
    ){
        if(team != null && pos != null){
            return playerService.getPlayerFromTeam(team);
        } else if (name != null) {
            return playerService.getPlayerByName(name);
        } else {
            return playerService.getPlayer();
        }
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player createPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createPlayer, HttpStatus.CREATED);
    }

    @PostMapping("/signup")
    public void login(@RequestBody User user){
    //userService.saveNewUSer(user);
    }
}
