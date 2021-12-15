package com.server.projet.ressources.song;

import com.server.projet.ressources.artist.Artist;
import com.server.projet.ressources.feedback.Feedback;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Song implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long id;
    public String title;
    @ManyToOne
    public Artist singer;
    public Date date;
    public String type;
    @OneToMany
    public List<Feedback> feedbacks;

    public Song(){super();}

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

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }
}
