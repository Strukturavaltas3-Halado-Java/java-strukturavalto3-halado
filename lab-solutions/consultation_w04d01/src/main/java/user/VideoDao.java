package user;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class VideoDao {

    private EntityManagerFactory entityManagerFactory;

    public VideoDao(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public Video saveVideo(Video video) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(video);
        em.getTransaction().commit();
        em.close();
        return video;
    }

    public Video findVideo(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Video video = entityManager.find(Video.class, id);
        entityManager.close();
        return video;
    }
}
