package com.training360.springrestmoviedemo.movie.services;

import com.training360.springrestmoviedemo.movie.dtos.AddRatingCommand;
import com.training360.springrestmoviedemo.movie.dtos.CreateMovieCommand;
import com.training360.springrestmoviedemo.movie.dtos.MovieDto;
import com.training360.springrestmoviedemo.movie.dtos.UpdateMovieCommand;
import com.training360.springrestmoviedemo.movie.exceptions.MovieNotFoundException;
import com.training360.springrestmoviedemo.movie.mappers.MovieMapper;
import com.training360.springrestmoviedemo.movie.model.Movie;
import com.training360.springrestmoviedemo.movie.repository.MovieRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;


    public List<MovieDto> getAllMovies(Optional<String> movieTitle) {

        List<Movie> movies;

        if(movieTitle.isPresent()){
            movies = movieRepository.findMovieByTitleContains(movieTitle.get());
        }else{
            movies = movieRepository.findAll();
        }
        return movieMapper.toDto(movies);
    }


    @Transactional
    public MovieDto createMovie(CreateMovieCommand command) {
        Movie movie = new Movie(command.getTitle(),command.getLength());
        movieRepository.save(movie);
        return movieMapper.toDto(movie);
    }

    public MovieDto findMovieById(long id) {

        return movieMapper.toDto(findById(id));
    }


    private Movie findById(long id){
       Optional<Movie> movie = movieRepository.findById(id);
       if(movie.isEmpty()){
           throw new MovieNotFoundException(id);
       }

       return movie.get();
    }

    @Transactional
    public List<Integer> addRatingToMovie(long id, AddRatingCommand rating) {
        Movie movie = findById(id);
        movie.addRating(rating.getRating());

        return movie.getRatings();
    }

    public List<Integer> getMovieRatingsById(long id) {
        return findById(id).getRatings();
    }

    @Transactional
    public MovieDto updateMovie(long id, UpdateMovieCommand command) {
        Movie found = findById(id);
        found.setTitle(command.getTitle());
        found.setLength(command.getLength());

        return movieMapper.toDto(found);
    }

}
