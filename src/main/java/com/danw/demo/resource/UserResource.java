package com.danw.demo.resource;

import com.danw.demo.core.User;
import com.danw.demo.core.UserG;
import com.danw.demo.db.UserDAO;

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

    @Path("/createTable")
    @GET
    public Boolean  createTable(){
        try{
            userDAO.createSomethingTable();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @GET
    public List<UserG> getAllUser(){
        return userDAO.listUsers();
    }

    @POST
    public Boolean createUser(User user){
        try{
            userDAO.insert(user);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }


    @Path("/{userId}")
    @PUT
    public Boolean updateUser(@PathParam("userId") Long userId,User user){
        try{
            userDAO.update(userId,user);
            return true;
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Path("/{userId}")
    @GET
    public UserG getUser(@PathParam("userId") Long userId) {
        return userDAO.findUserById(userId);
    }

    @Path("/{userId}")
    @DELETE
    public Boolean deleteUser(@PathParam("userId") Long userId){
        try{
            userDAO.delete(userId);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
