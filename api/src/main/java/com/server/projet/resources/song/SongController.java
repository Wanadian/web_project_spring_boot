package com.server.projet.resources.song;

import com.server.projet.resources.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/songs")
public class SongController {
    @Autowired
    private SongService songService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSongs() {
        List<Song> songs = songService.getAllSongs();
        return !songs.isEmpty() ? Response.status(Response.Status.OK).entity(songs).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSongById(@PathParam("id") long id) {
        Song song = songService.getSongById(id);
        return song != null ? Response.status(Response.Status.OK).entity(song).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("/{artistId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSong(Song song, @PathParam("artistId") long artistId) {
        try {
            Song createdSong = songService.createSong(song, artistId);
            return Response.status(Response.Status.CREATED).entity(createdSong).build();
        } catch (BadRequestException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteSong(@PathParam("id") long id) {
        Song song = songService.deleteSongById(id);
        return song != null ? Response.status(Response.Status.OK).entity(song).build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
}
