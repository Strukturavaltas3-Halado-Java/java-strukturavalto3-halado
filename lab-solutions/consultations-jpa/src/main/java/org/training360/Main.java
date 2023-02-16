package org.training360;

import org.training360.week02.day02.Movie;
import org.training360.week02.day02.MovieRepository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
        try{
            MovieRepository repository = new MovieRepository(factory);

            Movie result = repository.saveMovie(new Movie("Star Wars",123,LocalDate.parse("1976-12-17")));

            System.out.println(repository.findMovieByTitle("Star Wars"));

        }finally {
            factory.close();
        }
    }
}