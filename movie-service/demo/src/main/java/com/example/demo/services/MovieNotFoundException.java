package com.example.demo.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(String id) {
        super("Movie not found: " + id);
    }
}
