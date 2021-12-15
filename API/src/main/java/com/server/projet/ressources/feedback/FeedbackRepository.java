package com.server.projet.ressources.feedback;

import com.server.projet.ressources.feedback.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {}
