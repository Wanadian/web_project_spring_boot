package com.server.projet.resources.artist;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference(value = "artist-song")
    public Set<Song> songs;

    public Artist(){super();}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }
}
