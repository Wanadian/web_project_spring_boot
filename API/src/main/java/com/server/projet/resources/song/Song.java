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
    @JsonBackReference
    public Artist singer;
    public Date date;
    public String type;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    public List<Feedback> feedbacks;

    public Song() {
        super();
    }

    public Artist getSinger() {
        return singer;
    }
}
