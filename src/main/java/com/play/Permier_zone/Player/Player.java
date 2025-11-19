package com.play.Permier_zone.Player;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "img_url")
    private String img;
    private String name;
    private String nation;
    private String team;
    private String pos;
    //Constructors
    public Player(){}

    public Player(
            String img,
            String name,
            String nation,
            String team,
            String pos){
        this.img = img;
        this.name = name;
        this.nation = nation;
        this.team = team;
        this.pos = pos;
    }

    //Getters and Setters
    public int getId(){
        return id;
    }
    public String getImg(){ return img; }
    public void setImg(String img) { this.img = img; }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setNation(String nation){ this.nation = nation; }
    public String getNation(){ return nation; }
    public void setPos(String pos){ this.pos = pos; }
    public String getPos(){ return pos; }
    public String getTeam(){ return team;}
    public void setTeam(String team){ this.team = team;}
}
