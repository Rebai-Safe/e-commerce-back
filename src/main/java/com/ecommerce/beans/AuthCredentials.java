package com.ecommerce.beans;

public class AuthCredentials {
    private String userName;
    private String password;

    public AuthCredentials(String userName, String lastName) {
        this.userName = userName;
        this.password = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
