package com.server.projet.resources.artist;

import com.server.projet.resources.exception.BadRequestException;
import com.server.projet.resources.song.Song;
import com.server.projet.resources.song.SongService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/artists")
public class ArtistController {
    @Autowired
    private ArtistService artistService;
    @Autowired
    private SongService songService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllArtists() {
        List<Artist> artists = artistService.getAllArtists();
        return !artists.isEmpty() ? Response.status(Response.Status.OK).entity(artists).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArtistById(@PathParam("id") long id) {
        Artist artist = artistService.getArtistById(id);
        return artist != null ? Response.status(Response.Status.OK).entity(artist).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/{id}/songs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSongsOfArtist(@PathParam("id") long id) {
        List<Song> songs = songService.getAllSongsByArtistId(id);
        return !songs.isEmpty() ? Response.status(Response.Status.OK).entity(songs).build() : Response.status(Response.Status.NOT_FOUND).build();
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
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteArtist(@PathParam("id") long id) {
        Artist artist = artistService.deleteArtistById(id);
        return artist != null ? Response.status(Response.Status.OK).entity(artist).build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
}
