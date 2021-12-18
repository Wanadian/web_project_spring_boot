package com.server.projet.resources.song;

import com.server.projet.resources.BadRequestException;
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
    @Path("/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSongByTitle(@PathParam("title") String title) {
        Song song = songService.getSongByTitle(title);
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
    @Path("/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteSong(@PathParam("title") String title) {
        Song song = songService.deleteSongByTitle(title);
        return song != null ? Response.status(Response.Status.OK).entity(song).build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
}
