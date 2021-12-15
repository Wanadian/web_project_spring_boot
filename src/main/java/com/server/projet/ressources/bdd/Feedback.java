package com.server.projet.ressources.bdd;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Feedback implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long id;
    @ManyToOne
    public User User;
    @ManyToOne
    public Song Song;
    public int mark;
    public String comment;

    public Feedback(){super();}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public com.server.projet.ressources.bdd.User getUser() {
        return User;
    }

    public void setUser(com.server.projet.ressources.bdd.User user) {
        User = user;
    }

    public com.server.projet.ressources.bdd.Song getSong() {
        return Song;
    }

    public void setSong(com.server.projet.ressources.bdd.Song song) {
        Song = song;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int note) {
        this.mark = note;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
