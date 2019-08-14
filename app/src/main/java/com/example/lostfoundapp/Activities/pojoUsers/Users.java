package com.example.lostfoundapp.Activities.pojoUsers;

import java.io.Serializable;

public class Users implements Serializable
{
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    int userID;
    String userEmail;
    String userPassword;
}