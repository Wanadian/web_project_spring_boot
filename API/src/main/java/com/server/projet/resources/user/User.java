package com.server.projet.resources.user;

import com.server.projet.resources.feedback.Feedback;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable {
    @Id
    public long id;
    public String pseudo;
    public int age;
    public String email;
    public String password;
    @OneToMany
    public List<Feedback> feedbacks;

    public User(){super();}
}
