package com.example.Authentication.entity;
;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "userinfo")
public class User {


    private String userId;
    private String userName;
    @Id
    private String userMail;
    private String userPswd;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String loginTimeStamp = "";
    private String userImageUrl;

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }



    public String getUserId() {
        return userId;
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

    public String getUserPswd() {
        return userPswd;
    }

    public void setUserPswd(String userPswd) {
        this.userPswd = userPswd;
    }

    public String getLoginTimeStamp() {
        return loginTimeStamp;
    }

    public void setLoginTimeStamp(String loginTimeStamp) {
        this.loginTimeStamp = loginTimeStamp;
    }
}
