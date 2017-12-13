package com.danw.demo.resource;

import com.danw.demo.core.Group;
import com.danw.demo.core.GroupU;
import com.danw.demo.db.GroupDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/group")
@Produces(MediaType.APPLICATION_JSON)
public class GroupResource {
    private final GroupDAO groupDAO;
    public GroupResource(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }
    @GET
    public List<Group> findAll(){
        return groupDAO.list();
    }
    @GET
    @Path("/{groupId}")
    public Object groupInfo(@PathParam("groupId") Long groupId){
        return groupDAO.groupInfo(groupId);
    }
}
