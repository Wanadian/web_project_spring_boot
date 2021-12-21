package com.server.projet.resources.artist;

import com.server.projet.resources.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {
    private ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getAllArtists() {
        List<Artist> artists = new ArrayList<>();
        artistRepository.findAll().forEach(artists::add);
        return artists;
    }

    public Artist getArtistByName(String name) {
        Optional<Artist> artist = artistRepository.findByName(name);
        return artist.isPresent() ? artist.get() : null;
    }

    public Artist createArtist(Artist artist) throws BadRequestException {
        Artist fetchedArtist = getArtistByName(artist.getName());
        if (fetchedArtist != null) {
            throw new BadRequestException("Artist already exists");
        }
        artistRepository.save(artist);
        return artist;
    }

    @Transactional
    public Artist deleteArtistByName(String name) {
        Optional<Artist> artist = artistRepository.findByName(name);
        if (artist.isPresent()) {
            try {
                artistRepository.deleteByName(name);
                return artist.get();
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
