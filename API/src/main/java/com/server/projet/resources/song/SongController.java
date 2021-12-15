package com.server.projet.resources.song;

import com.server.projet.resources.artist.Artist;
import com.server.projet.resources.artist.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Path("song")
public class SongController {
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private ArtistRepository artistRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Song> getAllSong() {
        List<Song> songs = new ArrayList<>();
        songRepository.findAll().forEach(songs::add);
        return songs;
    }

    @GET
    @Path("{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSongByTitle (@PathParam("title") String title){
        Optional<Song> song = songRepository.findByTitle(title);
        if(song.isPresent()){
            return Response.ok(song.get()).build();
        }
        else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSong(Song song) {
        Optional<Artist> artist = artistRepository.findByName(song.getSinger().getName());
        if (artist.isPresent()){
            Set<Song> artistSongs = artist.get().getSongs();
            artistSongs.add(song);
            songRepository.save(song);
            return Response.status(Response.Status.CREATED).build();
        }
        else{
            return Response.status(Response.Status.PRECONDITION_FAILED).build();
        }
    }

    @DELETE
    @Path("{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteSong(@PathParam("title") String title) {
        Optional<Song> song = songRepository.findByTitle(title);
        if (song.isPresent()) {
            try {
                Optional<Artist> artist = artistRepository.findByName(song.get().getSinger().getName());
                Set<Song> artistSongs = artist.get().getSongs();
                artistSongs.remove(song);
                songRepository.deleteByTitle(title);
            } catch (Exception e) {
                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }
        }
        return Response.status(Response.Status.OK).build();
    }
}
