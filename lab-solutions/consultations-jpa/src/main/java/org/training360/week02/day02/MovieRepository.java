package org.training360.week02.day02;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

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

    //JPQL
    public List<Movie> findMovieByTitle(String title){
       EntityManager entityManager = factory.createEntityManager();
       try {
          List<Movie> movies = entityManager.createQuery("select m from Movie m where m.title= ?1",Movie.class)
                   .setParameter(1,title)
                  .getResultList();
           return movies;
       }finally {
           entityManager.close();
       }

    }

    public Movie updateMovieTitle(long id, String title){
        EntityManager manager = factory.createEntityManager();
        try{
            manager.getTransaction().begin();
            Movie movie = manager.getReference(Movie.class,id);
            movie.setTitle(title);
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
