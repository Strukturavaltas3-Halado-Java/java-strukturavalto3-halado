package org.training360.week03.day02;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class UserRepository {

    private EntityManagerFactory factory;

    public UserRepository(EntityManagerFactory factory) {
        this.factory = factory;
    }


    public YoutubeUser registerUser(YoutubeUser user){
        EntityManager entityManager = factory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            return user;
        }finally {
            entityManager.close();
        }
    }

    public YoutubeUser updateUserWithVideo(long userId, Video video){
        EntityManager entityManager = factory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            YoutubeUser user = entityManager.find(YoutubeUser.class,userId);
            entityManager.persist(video);
            video.setUser(user);
            user.getVideos().size();
            entityManager.getTransaction().commit();
            return user;
        }finally {
            entityManager.close();
        }
    }

    public YoutubeUser findUser(long userId){
        EntityManager manager = factory.createEntityManager();
        try{
            return manager.find(YoutubeUser.class, userId);
        }finally {
            manager.close();
        }
    }


}
