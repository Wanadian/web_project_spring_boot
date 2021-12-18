package com.server.projet.resources.song;

import com.server.projet.resources.exception.BadRequestException;
import com.server.projet.resources.artist.Artist;
import com.server.projet.resources.artist.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private SongRepository songRepository;
    private ArtistRepository artistRepository;

    @Autowired
    public SongService(SongRepository songRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    public List<Song> getAllSongs() {
        List<Song> songs = new ArrayList<>();
        songRepository.findAll().forEach(songs::add);
        return songs;
    }

    public Song getSongByTitle(String title) {
        Optional<Song> song = songRepository.findByTitle(title);
        return song.isPresent() ? song.get() : null;
    }

    public Song createSong(Song song, long artistId) throws BadRequestException {
        Song fetchedSong = getSongByTitle(song.getTitle());
        if (fetchedSong != null) {
            throw new BadRequestException("Song already exists");
        }
        Optional<Artist> artist = artistRepository.findById(artistId);
        if (artist.isPresent()) {
            song.setSinger(artist.get());
            songRepository.save(song);
            return song;
        } else {
            throw new BadRequestException("Artist does not exist");
        }
    }

    @Transactional
    public Song deleteSongByTitle(String title) {
        Optional<Song> song = songRepository.findByTitle(title);
        if (song.isPresent()) {
            try {
                songRepository.deleteByTitle(title);
                return song.get();
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
