package com.server.projet;

//import com.server.projet.resources.artist.ArtistController;
//import com.server.projet.resources.song.SongController;
import com.server.projet.resources.user.UserController;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("")
@Configuration
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
        register(CORSResponseFilter.class);
        //register(SongController.class);
        register(UserController.class);
        //register(ArtistController.class);
    }
}