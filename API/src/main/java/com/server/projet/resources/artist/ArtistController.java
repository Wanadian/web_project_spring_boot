package com.server.projet.resources.artist;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/artists")
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllArtist() {
        List<Artist> artists = artistService.getAllArtists();
        if (!artists.isEmpty()) {
            return Response.ok(artists).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArtistByName(@PathParam("name") String name) {
        Artist artist = artistService.getArtistByName(name);
        if (artist != null) {
            return Response.ok(artist).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createArtist(Artist artist) {
        artistService.createArtist(artist);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteArtist(@PathParam("name") String name) {
        Boolean response = artistService.deleteArtistByName(name);
        if (response) {
            return Response.status(Response.Status.ACCEPTED).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
