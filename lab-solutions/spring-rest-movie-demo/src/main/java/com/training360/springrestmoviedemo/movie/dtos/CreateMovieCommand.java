package com.training360.springrestmoviedemo.movie.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateMovieCommand {

    @NotBlank
    private String title;
    @Positive(message = "Length must be positive!")
    private int length;
}
