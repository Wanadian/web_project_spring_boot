package com.server.projet.resources.feedback;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.server.projet.resources.song.Song;
import com.server.projet.resources.user.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Feedback implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "user-feedback")
    public User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "song-feedback")
    public Song song;
    public int mark;
    public String comment;

    public Feedback() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
