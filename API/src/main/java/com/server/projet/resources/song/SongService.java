package com.server.projet.resources.song;

import com.server.projet.resources.artist.Artist;
import com.server.projet.resources.artist.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        return songRepository.findByTitle(title).get();
    }

    public Song createSong(Song song) {
        songRepository.save(song);
        return song;
    }

    public boolean deleteSongByTitle(String title) {
        Song song = songRepository.findByTitle(title).get();
        if (song != null) {
            try {
                Artist artist = artistRepository.findByName(song.getSinger().getName()).get();
                Set<Song> artistSongs = artist.getSongs();
                artistSongs.remove(song);
                songRepository.deleteByTitle(title);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
