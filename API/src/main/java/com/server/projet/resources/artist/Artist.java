package com.server.projet.resources.artist;

import com.server.projet.resources.song.Song;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Artist implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long id;
    public String name;
    @OneToMany
    public Set<Song> songs;

    public Artist(){super();}

    public String getName() {
        return name;
    }

    public Set<Song> getSongs() {
        return songs;
    }
}
