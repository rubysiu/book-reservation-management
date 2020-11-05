package com.xx.domain;

public class Admin {
    private Integer id;
    private String token;

    public Admin(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public Admin() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", token='" + token + '\'' +
                '}';
    }
}
