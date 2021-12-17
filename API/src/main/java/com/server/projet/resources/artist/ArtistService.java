package com.server.projet.resources.artist;

import com.server.projet.resources.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistService {
    private ArtistRepository artistRepository;
    private UserRepository userRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository, UserRepository userRepository) {
        this.artistRepository = artistRepository;
        this.userRepository = userRepository;
    }

    public List<Artist> getAllArtists() {
        List<Artist> artists = new ArrayList<>();
        artistRepository.findAll().forEach(artists::add);
        return artists;
    }

    public Artist getArtistByName(String name) {
        return artistRepository.findByName(name).get();
    }

    public Artist createArtist(Artist artist) {
        artistRepository.save(artist);
        return artist;
    }

    public Boolean deleteArtistByName(String name) {
        if (artistRepository.findByName(name).isPresent()) {
            try {
                artistRepository.deleteByName(name);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
