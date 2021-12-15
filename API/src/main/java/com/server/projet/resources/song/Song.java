package com.server.projet.resources.song;

import com.server.projet.resources.artist.Artist;
import com.server.projet.resources.feedback.Feedback;

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
}
