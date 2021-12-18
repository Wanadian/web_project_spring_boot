package com.server.projet.resources.feedback;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/comments")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GET
    @Path("/{songTitle}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFeedbackOfSong(@PathParam("songTitle") String songTitle) {
        List<Feedback> feedback = feedbackService.getAllFeedbackBySong(songTitle);
        return !feedback.isEmpty() ? Response.status(Response.Status.OK).entity(feedback).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("/{songId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response commentSong(Feedback feedback, @PathParam("songId") long songId) {
        Feedback createdFeedback = feedbackService.createFeedbackToSong(songId, feedback);
        return createdFeedback != null ? Response.status(Response.Status.OK).entity(createdFeedback).build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
}
