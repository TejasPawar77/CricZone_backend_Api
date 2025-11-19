package com.play.Permier_zone.dto;

public class RegisterUserDto {
    public String getEmail;
    private String email;
    private String password;
    private String username;

    void getEmail(String email){
        this.email = email;
    }
    String getEmail(){
        return email;
    }
    void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
}
