package com.training360.springrestmoviedemo.movie.mappers;

import com.training360.springrestmoviedemo.movie.dtos.MovieDto;
import com.training360.springrestmoviedemo.movie.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    List<MovieDto> toDto(List<Movie> movies);


    MovieDto toDto(Movie movie);
}
