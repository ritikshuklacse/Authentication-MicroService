package com.example.Authentication.dto;

public class UserDetails {
     private String userId;
    private String userName;
    private String userMail;
    private String userImageUrl;
    private String loginTimeStamp;

    public String getUserId() {
        return userId;
    }

    public String getLoginTimeStamp() {
        return loginTimeStamp;
    }

    public void setLoginTimeStamp(String loginTimeStamp) {
        this.loginTimeStamp = loginTimeStamp;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }
}
