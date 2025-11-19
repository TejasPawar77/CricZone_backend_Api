package com.play.Permier_zone.Response;

public class LoginResponse {
    private String token;
    private long expiresIn;
    public LoginResponse(String token, long expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
    }
    public void setToken(String token){
        this.token = token;
    }
    public String getToken(){
        return token;
    }
    public void setExpiresIn(long expiresIn){
        this.expiresIn = expiresIn;
    }
    public long getExpiresIn(){
        return expiresIn;
    }
}
