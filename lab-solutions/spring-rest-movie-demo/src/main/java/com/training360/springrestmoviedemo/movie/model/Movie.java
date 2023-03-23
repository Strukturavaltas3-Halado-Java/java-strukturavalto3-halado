package com.training360.springrestmoviedemo.movie.model;

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
public class Movie {

    private Long id;
    private String title;
    private int length;
    private List<Integer> ratings = new ArrayList<>();
    private double averageRating;


    public Movie(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public void addRating(int rating){
        ratings.add(rating);
        updateAverageRating();
    }

    private void updateAverageRating(){
        averageRating = ratings.stream().mapToDouble(d->d).average().getAsDouble();
    }
}
