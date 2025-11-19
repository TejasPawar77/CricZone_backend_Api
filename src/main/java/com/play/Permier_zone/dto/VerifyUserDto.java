package com.play.Permier_zone.dto;

public class VerifyUserDto {
    private String email;
    private String verificationCode;

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setVerificationCode(String verificationCode){
        this.verificationCode = verificationCode;
    }
    public String getVerificationCode(){
        return verificationCode;
    }

}
