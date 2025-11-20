package com.djamware.resource;

import java.util.List;

import com.djamware.entity.User;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @GET
    public List<User> listUsers() {
        return User.listAll();
    }

    @POST
    @Transactional
    public User create(User user) {
        user.persist();
        return user;
    }

    @GET
    @Path("/{id}")
    public User get(@PathParam("id") Long id) {
        return User.findById(id);
    }
}
