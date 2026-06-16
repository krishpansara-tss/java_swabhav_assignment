package com.shopingmanagement.model;

public class User {
    private long nextId = 100;
    private String userId;
    private String name;

    public User(String name) {
        this.userId = "UID" + ++nextId;
        this.name = name;
    }
}
