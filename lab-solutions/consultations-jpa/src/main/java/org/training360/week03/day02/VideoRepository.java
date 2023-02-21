package org.training360.week03.day02;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class VideoRepository {

    private EntityManagerFactory factory;

    public VideoRepository(EntityManagerFactory factory) {
        this.factory = factory;
    }


    public Video saveVideo(Video video){
        EntityManager entityManager = factory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(video);
            entityManager.getTransaction().commit();
            return video;
        }finally {
            entityManager.close();
        }
    }

    public void connectVideoToUser(long videoId, long userId){
        EntityManager entityManager = factory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            YoutubeUser user = entityManager.find(YoutubeUser.class, userId);
            Video video = entityManager.find(Video.class, videoId);
            video.setUser(user);
            entityManager.getTransaction().commit();
        }finally {
            entityManager.close();
        }
    }

    public Video findVideoById(long videoId){
        EntityManager entityManager = factory.createEntityManager();
        try{
            return entityManager.find(Video.class,videoId);
        }finally {
            entityManager.close();
        }
    }
}
