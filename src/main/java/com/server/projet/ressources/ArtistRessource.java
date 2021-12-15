package com.server.projet.ressources;

import com.server.projet.ressources.bdd.Artist;
import com.server.projet.ressources.bdd.ArtistRepository;
import com.server.projet.ressources.bdd.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("artist")
public class ArtistRessource {
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private UserRepository userRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Artist> getAllArtist() {
        List<Artist> artists = new ArrayList<>();
        artistRepository.findAll().forEach(artists::add);
        return artists;
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArtistByName(@PathParam("name") String name){
        Optional<Artist> artist = artistRepository.findByName(name);
        if(artist.isPresent()){
            return Response.ok(artist.get()).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createArtist(Artist artist) {
        artistRepository.save(artist);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteArtist(@PathParam("name") String name) {
        if (artistRepository.findByName(name).isPresent()) {
            try {
                artistRepository.deleteByName(name);
            } catch (Exception e) {
                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }
        }
        return Response.status(Response.Status.OK).build();
    }
}
