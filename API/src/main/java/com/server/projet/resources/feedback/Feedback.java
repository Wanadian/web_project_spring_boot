package com.server.projet.resources.feedback;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.server.projet.resources.song.Song;
import com.server.projet.resources.user.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Feedback implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    public User user;
    @ManyToOne(fetch = FetchType.LAZY)
    public Song Song;
    public int mark;
    public String comment;

    public Feedback(){super();}
}
