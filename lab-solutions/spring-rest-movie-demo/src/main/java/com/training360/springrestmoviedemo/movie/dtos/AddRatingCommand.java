package com.training360.springrestmoviedemo.movie.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddRatingCommand {

    private int rating;
}
