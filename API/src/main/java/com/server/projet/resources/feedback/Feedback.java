package com.server.projet.resources.feedback;

import com.server.projet.resources.user.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Feedback implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long id;
    @ManyToOne
    public User user;
    @ManyToOne
    public com.server.projet.resources.song.Song Song;
    public int mark;
    public String comment;

    public Feedback(){super();}
}
