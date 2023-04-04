package com.training360.springrestmoviedemo.movie.services;

import com.training360.springrestmoviedemo.movie.dtos.CreateMovieCommand;
import com.training360.springrestmoviedemo.movie.dtos.MovieDto;
import com.training360.springrestmoviedemo.movie.mappers.MovieMapper;
import com.training360.springrestmoviedemo.movie.mappers.MovieMapperImpl;
import com.training360.springrestmoviedemo.movie.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {
    @Mock
    MovieRepository repository;

    MovieService service;

    @BeforeEach
    void init(){
        service= new MovieService(repository, new MovieMapperImpl());
    }


    @Test
    void getAllMoviesTest(){

        service.createMovie(new CreateMovieCommand("Titanic",101));
        service.createMovie(new CreateMovieCommand("Jurassic Park",101));

        List<MovieDto> result = service.getAllMovies(Optional.empty());

        assertEquals(2, result.size());
    }

}