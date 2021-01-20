package com.example.Authentication.dto;

public class UserChangePassword {
    private String userMail;
    private String oldUserPswd;
    private String newUserPswd;

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getOldUserPswd() {
        return oldUserPswd;
    }

    public void setOldUserPswd(String oldUserPswd) {
        this.oldUserPswd = oldUserPswd;
    }

    public String getNewUserPswd() {
        return newUserPswd;
    }

    public void setNewUserPswd(String newUserPswd) {
        this.newUserPswd = newUserPswd;
    }
}
