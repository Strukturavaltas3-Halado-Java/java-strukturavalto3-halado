package org.training360.week03.day01.user;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class UserDao {

    private EntityManagerFactory entityManagerFactory;

    public UserDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public User saveUser(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        return user;
    }



    public User findUser(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = entityManager.find(User.class, id);
        entityManager.close();
        return user;
    }

//    public User saveVideoToUser(Long id, String video) {
    public User saveVideoToUser(Long id, Video video) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        user.addVideo(video);
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }

    public User findUserWithVideos(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User found = entityManager.createQuery("select distinct u from YoutubeUser u left join fetch u.videos where u.id = :id",
                User.class)
                .setParameter("id", id)
                .getSingleResult();
        entityManager.close();
        return found;
    }
}
