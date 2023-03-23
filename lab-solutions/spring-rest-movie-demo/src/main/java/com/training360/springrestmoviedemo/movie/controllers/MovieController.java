package com.training360.springrestmoviedemo.movie.controllers;

import com.training360.springrestmoviedemo.movie.dtos.AddRatingCommand;
import com.training360.springrestmoviedemo.movie.dtos.CreateMovieCommand;
import com.training360.springrestmoviedemo.movie.dtos.MovieDto;
import com.training360.springrestmoviedemo.movie.services.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
@AllArgsConstructor
public class MovieController {

    private MovieService service;

    @GetMapping
    public List<MovieDto> getAllMovies(){
        return service.getAllMovies();
    }

    @GetMapping("/{id}")
    public MovieDto findMovieById(@PathVariable("id") long id){
        return service.findMovieById(id);
    }

    @PostMapping
    public MovieDto createMovie(@RequestBody CreateMovieCommand command){
        return service.createMovie(command);
    }

    @PostMapping("/{id}/ratings")
    public List<Integer> addNewRating(@PathVariable("id") long id, @RequestBody AddRatingCommand rating){
        return service.addRatingToMovie(id, rating);
    }

    @GetMapping("/{id}/ratings")
    public List<Integer> findMovieRatings(@PathVariable("id") long id){
        return service.getMovieRatingsById(id);
    }
}
