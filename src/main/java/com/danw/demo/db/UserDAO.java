package com.danw.demo.db;

import com.danw.demo.core.User;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;
public class UserDAO extends AbstractDAO<User> {
    public UserDAO(SessionFactory factory) {
        super(factory);
    }
    public User findById(Long id) {

        return get(id);
    }

    public User create(User user) {
        User u = persist(user);
        return u;
    }

    public List<User> findAll() {
        return super.list()

//        return list(namedQuery("com.danw.demo.core.User.findAll"));
    }

}
