package com.danw.demo.core;

import javax.persistence.*;

@Entity
@Table(name = "t_user")
@NamedQueries(
        {
                @NamedQuery(
                        name = "com.danw.demo.core.User.findAll",
                        query = "SELECT p FROM User p"
                )
        }
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "age", nullable = false)
    private String age;

    public User() {
    }
    public User(String name, String age) {
        this.name = name;
        this.age = age;
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
