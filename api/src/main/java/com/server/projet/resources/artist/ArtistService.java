package com.server.projet.resources.artist;

import com.server.projet.resources.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.desktop.QuitResponse;
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

    public Artist getArtistById(long artistId) {
        Optional<Artist> artist = artistRepository.findById(artistId);
        return artist.isPresent() ? artist.get() : null;
    }

    public Artist createArtist(Artist artist) throws BadRequestException {
        Optional<Artist> fetchedArtist = artistRepository.findByName(artist.getName());
        if (fetchedArtist.isPresent()) {
            throw new BadRequestException("Artist already exists");
        }
        artistRepository.save(artist);
        return artist;
    }

    @Transactional
    public Artist deleteArtistById(long artistId) {
        Optional<Artist> artist = artistRepository.findById(artistId);
        if (artist.isPresent()) {
            try {
                artistRepository.deleteById(artistId);
                return artist.get();
            } catch (Exception e) {
                System.out.println("ahhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
                System.out.println(e);
                return null;
            }
        }
        return null;
    }
}