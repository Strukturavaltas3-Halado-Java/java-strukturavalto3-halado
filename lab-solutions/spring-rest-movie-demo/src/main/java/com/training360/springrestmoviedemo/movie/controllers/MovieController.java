package com.training360.springrestmoviedemo.movie.controllers;

import com.training360.springrestmoviedemo.movie.dtos.AddRatingCommand;
import com.training360.springrestmoviedemo.movie.dtos.CreateMovieCommand;
import com.training360.springrestmoviedemo.movie.dtos.MovieDto;
import com.training360.springrestmoviedemo.movie.dtos.UpdateMovieCommand;
import com.training360.springrestmoviedemo.movie.services.MovieService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/movies")
@AllArgsConstructor
public class MovieController {

    private MovieService service;


    @GetMapping
    public List<MovieDto> getAllMovies(@RequestParam Optional<String> movieTitle){
        return service.getAllMovies(movieTitle);
    }


    @GetMapping("/{id}")
    public MovieDto findMovieById(@PathVariable("id") long id){
        return service.findMovieById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDto createMovie(@Valid @RequestBody CreateMovieCommand command){
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

   @PutMapping("/{id}")
   @ResponseStatus(HttpStatus.CREATED)
    public MovieDto updateMovie(@PathVariable("id") long id, @Valid @RequestBody UpdateMovieCommand command){
        return service.updateMovie(id, command);
   }


}
