package com.danw.demo.core;

public class UserG {
    private long id;
    private String name;
    private String age;
    private long group_id;
    private String group_name;

    public UserG(long id, String name, String age, long group_id, String group_name) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.group_id = group_id;
        this.group_name = group_name;
    }

    public UserG() {
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

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }
}
