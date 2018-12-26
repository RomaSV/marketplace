package com.springingdream.marketplace.collectors.requests;


public class UserRequest {
    private String login;
    private String passwordHash;
    private Long uid;
    private String imageUrl;

    public UserRequest() {

    }

    public UserRequest(String login, String passwordHash) {
        this.login = login;
        this.passwordHash = passwordHash;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
