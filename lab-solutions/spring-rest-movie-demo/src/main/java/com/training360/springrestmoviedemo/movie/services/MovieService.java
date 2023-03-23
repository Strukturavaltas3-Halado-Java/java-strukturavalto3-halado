package com.training360.springrestmoviedemo.movie.services;

import com.training360.springrestmoviedemo.movie.dtos.AddRatingCommand;
import com.training360.springrestmoviedemo.movie.dtos.CreateMovieCommand;
import com.training360.springrestmoviedemo.movie.dtos.MovieDto;
import com.training360.springrestmoviedemo.movie.mappers.MovieMapper;
import com.training360.springrestmoviedemo.movie.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MovieService {

    private AtomicLong idGenerator = new AtomicLong(0);
    private List<Movie> movies = new ArrayList<>();
    private MovieMapper movieMapper;

    public MovieService(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    public List<MovieDto> getAllMovies() {
        return movieMapper.toDto(movies);
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
}
