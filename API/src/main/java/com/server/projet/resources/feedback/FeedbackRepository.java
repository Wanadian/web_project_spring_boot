package com.server.projet.resources.feedback;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
    Optional<Feedback> findBySongTitle (String songTitle);
}
