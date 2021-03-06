package com.danw.demo.core;

public class User {
    private long id;
    private String name;
    private String age;

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    private int group_id;

    public User(long id, String name, String age, int group_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.group_id = group_id;
    }

    public User() {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
