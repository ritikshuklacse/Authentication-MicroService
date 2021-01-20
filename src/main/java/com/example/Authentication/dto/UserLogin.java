package com.example.Authentication.dto;

public class UserLogin {

    private String userMail;
    private String userPswd;

//    public UserLogin(String userMail, String userPswd) {
//        this.userMail = userMail;
//        this.userPswd = userPswd;
//    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPswd() {
        return userPswd;
    }

    public void setUserPswd(String userPswd) {
        this.userPswd = userPswd;
    }
}
