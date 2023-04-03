package com.training360.springrestmoviedemo.movie.repository;

import com.training360.springrestmoviedemo.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

   List<Movie> findMovieByTitleContains(String part);
}
