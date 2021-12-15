package com.server.projet.resources.song;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
    Optional<Song> findByTitle(String title);
    int deleteByTitle(String title);
}
