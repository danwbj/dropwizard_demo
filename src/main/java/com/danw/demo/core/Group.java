package com.danw.demo.core;


import java.util.List;
import java.util.Set;

public class Group {
    private long id;
    private String name;
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Group(long id, String name, List<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Group() {
    }

    public Group(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
