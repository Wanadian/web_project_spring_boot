package com.server.projet;

import com.server.projet.ressources.ArtistRessource;
import com.server.projet.ressources.SongRessource;
import com.server.projet.ressources.UserRessource;
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
        register(SongRessource.class);
        register(UserRessource.class);
        register(ArtistRessource.class);
        register(CORSResponseFilter.class);
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
    }
}