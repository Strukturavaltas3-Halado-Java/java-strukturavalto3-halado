package org.training360.week02.day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {

    EntityManagerFactory entityManagerFactory;
    MovieRepository repository;

    @BeforeEach
    void init(){
        entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        repository = new MovieRepository(entityManagerFactory);
    }

    @AfterEach
    void afterEachTest(){
        entityManagerFactory.close();
    }

    @Test
    void testUpdateTitle(){
        Movie movie = repository.saveMovie(new Movie("Titanic",123, LocalDate.parse("1997-12-17")));
        repository.updateMovieTitle(movie.getId(),"Titanic 2");

        movie = repository.findById(movie.getId());

        assertEquals("Titanic 2",movie.getTitle());
    }

}