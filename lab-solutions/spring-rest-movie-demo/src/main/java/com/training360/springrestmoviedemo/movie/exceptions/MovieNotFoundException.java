package com.training360.springrestmoviedemo.movie.exceptions;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(long id) {
        super(String.format("Movie not found with id %d",id));
    }
}
