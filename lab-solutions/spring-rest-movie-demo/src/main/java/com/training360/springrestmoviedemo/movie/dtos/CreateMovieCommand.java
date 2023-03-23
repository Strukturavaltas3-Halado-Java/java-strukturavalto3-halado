package com.training360.springrestmoviedemo.movie.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateMovieCommand {

    private String title;
    private int length;
}
