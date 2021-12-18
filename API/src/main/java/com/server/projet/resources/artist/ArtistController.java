package com.server.projet.resources.artist;

import com.server.projet.resources.exception.BadRequestException;
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
        return !artists.isEmpty() ? Response.status(Response.Status.OK).entity(artists).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArtistByName(@PathParam("name") String name) {
        Artist artist = artistService.getArtistByName(name);
        return artist != null ? Response.status(Response.Status.OK).entity(artist).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createArtist(Artist artist) {
        try {
            Artist createdArtist = artistService.createArtist(artist);
            return Response.status(Response.Status.OK).entity(createdArtist).build();
        } catch (BadRequestException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteArtist(@PathParam("name") String name) {
        Artist artist = artistService.deleteArtistByName(name);
        return artist != null ? Response.status(Response.Status.OK).entity(artist).build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
}
