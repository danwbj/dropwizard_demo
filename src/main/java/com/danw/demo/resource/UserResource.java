package com.danw.demo.resource;

import com.danw.demo.core.User;
import com.danw.demo.db.UserDAO;
import io.dropwizard.hibernate.UnitOfWork;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private final UserDAO userDAO;

    public UserResource(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


//    @GET
//    @UnitOfWork
//    public User getPerson(@PathParam("userId") LongParam userId) {
////        return userDAO.findById(userId.get()).orElseThrow(() -> new NotFoundException("No such user."));
//        return userDAO.findById(userId.get());
//    }

    @POST
    @UnitOfWork
    public User createUser(User user){
        return userDAO.create(user);
    }

    @GET
    @UnitOfWork
    public List<User> getAllUser(){
        return userDAO.findAll();
    }



}
