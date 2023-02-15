package org.training360.week02.day02;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class MovieRepository {

    private EntityManagerFactory factory;

    public MovieRepository(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public Movie saveMovie(Movie movie){
        EntityManager manager = factory.createEntityManager();
        try{
            manager.getTransaction().begin();
            manager.persist(movie);
            manager.getTransaction().commit();
            return movie;
        }finally {
            manager.close();
        }
    }


    public Movie findById(long id){
        EntityManager manager = factory.createEntityManager();
        try{
            return manager.find(Movie.class,id);
        }finally {
            manager.close();
        }
    }
}
