package com.danw.demo.db;

import com.danw.demo.core.User;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserDAO extends AbstractDAO<User> {
    public UserDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

    public User create(User user) {
        User u = persist(user);
        return u;
    }

    public List<User> findAll() {
        return list(namedQuery("com.danw.demo.core.User.findAll"));
    }

    public boolean deleteById(Long id){
        try{
            Session session = this.currentSession();
            session.delete(Objects.requireNonNull(get(id)));
            return true;
        }catch(Exception e){
            return false;
        }
    }


}
