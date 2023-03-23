package com.training360.springrestmoviedemo.movie.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieDto {

    private Long id;
    private String title;
    private int length;
    private List<Integer> ratings;
    private double averageRating;

}
