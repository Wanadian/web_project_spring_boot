package com.server.projet.resources;

public class BadRequestException extends Exception{
    public BadRequestException(String message){
        super(message);
    }
}
