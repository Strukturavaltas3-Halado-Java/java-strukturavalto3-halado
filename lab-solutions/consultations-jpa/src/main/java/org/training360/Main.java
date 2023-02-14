package org.training360;

import org.training360.week02.day02.Movie;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new Movie("Titanic",123, LocalDate.parse("1997-12-17")));
        entityManager.getTransaction().commit();
        entityManager.close();

        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        entityManager1.getTransaction().begin();
        Movie movie = entityManager1.find(Movie.class,1L);
        movie.setLength(118);
        entityManager1.getTransaction().commit();
        entityManager1.close();
    }
}