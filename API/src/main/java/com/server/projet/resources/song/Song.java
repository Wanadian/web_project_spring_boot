package com.server.projet.resources.song;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.server.projet.resources.artist.Artist;
import com.server.projet.resources.feedback.Feedback;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Song implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String title;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "artist-song")
    public Artist singer;
    public Date date;
    public String type;
    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference(value = "song-feedback")
    public List<Feedback> feedback;

    public Song() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getSinger() {
        return singer;
    }

    public void setSinger(Artist singer) {
        this.singer = singer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Feedback> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<Feedback> feedback) {
        this.feedback = feedback;
    }
}
