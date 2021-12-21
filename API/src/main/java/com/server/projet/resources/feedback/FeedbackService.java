package com.server.projet.resources.feedback;

import com.server.projet.resources.song.Song;
import com.server.projet.resources.song.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {
    private FeedbackRepository feedbackRepository;
    private SongRepository songRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository, SongRepository songRepository) {
        this.feedbackRepository = feedbackRepository;
        this.songRepository = songRepository;
    }

    public Feedback createFeedbackToSong(long songId, Feedback feedback) {
        Optional<Song> song = songRepository.findById(songId);
        if (song.isPresent()) {
            feedback.setSong(song.get());
            feedbackRepository.save(feedback);
            return feedback;
        }
        return null;
    }

    public List<Feedback> getAllFeedbackBySong(String songTitle) {
        Optional<Song> song = songRepository.findByTitle(songTitle);
        return song.isPresent() ? song.get().getFeedback() : null;
    }
}
