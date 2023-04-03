package com.training360.springrestmoviedemo.movie.controllers;

import com.training360.springrestmoviedemo.movie.dtos.CreateMovieCommand;
import com.training360.springrestmoviedemo.movie.dtos.MovieDto;
import com.training360.springrestmoviedemo.movie.dtos.UpdateMovieCommand;
import com.training360.springrestmoviedemo.movie.services.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ProblemDetail;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovieControllerTestIT {

    @Autowired
    WebTestClient client;


    @Autowired
    MovieService service;

    @Test
    void testCreateMovie(){
       MovieDto result = client.post()
                .uri("/api/movies")
                .bodyValue(new CreateMovieCommand("Titanic",101))
                .exchange()
                .expectStatus().isEqualTo(201)
                .expectBody(MovieDto.class).returnResult().getResponseBody();


       assertEquals("Titanic",result.getTitle());
       assertEquals(101,result.getLength());
       assertNotNull(result.getId());
    }


    @Test
    void testCreateMovieWithWrongTitle(){
        ProblemDetail problemDetail= client.post()
                .uri("/api/movies")
                .bodyValue(new CreateMovieCommand("",120))
                .exchange()
                .expectStatus().isEqualTo(406)
                .expectBody(ProblemDetail.class).returnResult().getResponseBody();

        assertEquals(URI.create("movies/not-valid"),problemDetail.getType());
    }

    @Test
    void testFindMovieByPart() {
        client.post()
                .uri("/api/movies")
                .bodyValue(new CreateMovieCommand("Titanic", 101))
                .exchange();
        client.post()
                .uri("/api/movies")
                .bodyValue(new CreateMovieCommand("JP", 98))
                .exchange();


        List<MovieDto> result = client.get()
                .uri(uriBuilder -> uriBuilder.path("/api/movies").queryParam("movieTitle", "nic").build())
                .exchange()
                .expectBodyList(MovieDto.class).returnResult().getResponseBody();

        assertEquals(1, result.size());
    }

    @Test
    void testMovieNotFound(){
        ProblemDetail detail = client.get()
                .uri("/api/movies/{id}",1)
                .exchange()
                .expectStatus().isEqualTo(404)
                .expectBody(ProblemDetail.class).returnResult().getResponseBody();

        assertEquals(URI.create("movies/movie-not-found"),detail.getType());

    }


    @Test
    void testUpdateMovie(){
        MovieDto saved = client.post()
                .uri("/api/movies")
                .bodyValue(new CreateMovieCommand("Titanic",101))
                .exchange()
                .expectBody(MovieDto.class).returnResult().getResponseBody();

        MovieDto updated = client.put()
                .uri("/api/movies/{id}",saved.getId())
                .bodyValue(new UpdateMovieCommand("Jurassic Park",101))
                .exchange()
                .expectBody(MovieDto.class).returnResult().getResponseBody();

        assertEquals(updated.getId(),saved.getId());
        assertEquals(updated.getLength(),saved.getLength());
        assertEquals("Jurassic Park",updated.getTitle());
    }

}