package com.server.projet.resources.user;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUser(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @GET
    @Path("{pseudo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByPseudo (@PathParam("pseudo") String pseudo){
        Optional<User> user = userRepository.findByPseudo(pseudo);
        if(user.isPresent()){
            return Response.ok(user.get()).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSong(User user) {
        userRepository.save(user);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("{pseudo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("pseudo") String pseudo) {
        if (userRepository.findByPseudo(pseudo).isPresent()) {
            try {
                userRepository.deleteByPseudo(pseudo);
            } catch (Exception e) {
                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }
        }
        return Response.status(Response.Status.OK).build();
    }
}
