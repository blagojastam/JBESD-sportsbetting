package com.epam.training.domain;

public abstract class User {
    protected String email;
    protected String password; // because storing passwords in plaintext is cool :)

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
