package com.training360.springrestmoviedemo.movie.services;

import com.training360.springrestmoviedemo.movie.dtos.AddRatingCommand;
import com.training360.springrestmoviedemo.movie.dtos.CreateMovieCommand;
import com.training360.springrestmoviedemo.movie.dtos.MovieDto;
import com.training360.springrestmoviedemo.movie.dtos.UpdateMovieCommand;
import com.training360.springrestmoviedemo.movie.mappers.MovieMapper;
import com.training360.springrestmoviedemo.movie.model.Movie;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private AtomicLong idGenerator = new AtomicLong(0);
    private List<Movie> movies = Collections.synchronizedList(new ArrayList<>());
    private MovieMapper movieMapper;

    public MovieService(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    public List<MovieDto> getAllMovies(Optional<String> movieTitle) {
        if(movieTitle.isPresent()){
            List<Movie> result = findMoviesWithTitlePart(movieTitle.get());
            return movieMapper.toDto(result);
        }
        return movieMapper.toDto(movies);
    }

    private List<Movie> findMoviesWithTitlePart(String s) {
        return movies.stream()
                .filter(m->m.getTitle().toLowerCase().contains(s.toLowerCase()))
                .collect(Collectors.toList());
    }

    public MovieDto createMovie(CreateMovieCommand command) {
        Movie movie = new Movie(command.getTitle(),command.getLength());
        movie.setId(idGenerator.incrementAndGet());
        movies.add(movie);
        return movieMapper.toDto(movie);
    }

    public MovieDto findMovieById(long id) {

        return movieMapper.toDto(findById(id));
    }


    private Movie findById(long id){
        return  movies.stream()
                .filter(m->m.getId()==id)
                .findFirst().orElseThrow(()->new IllegalArgumentException("Cannot find movie with id: "+id));
    }

    public List<Integer> addRatingToMovie(long id, AddRatingCommand rating) {
        Movie movie = findById(id);
        movie.addRating(rating.getRating());

        return movie.getRatings();
    }

    public List<Integer> getMovieRatingsById(long id) {
        return findById(id).getRatings();
    }

    public MovieDto updateMovie(long id, UpdateMovieCommand command) {
        Movie found = findById(id);
        found.setTitle(command.getTitle());
        found.setLength(command.getLength());

        return movieMapper.toDto(found);
    }
}
