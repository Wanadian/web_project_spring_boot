package com.server.projet.ressources.bdd;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {
    Optional<Artist> findByName(String name);
    int deleteByName(String name);
}
