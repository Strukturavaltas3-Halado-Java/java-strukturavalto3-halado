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

    public Video saveTagToVideo(long videoId, long tagId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Video video = entityManager.find(Video.class, videoId);
            Tag tag = entityManager.find(Tag.class, tagId);
            video.addTag(tag);
            entityManager.getTransaction().commit();
            return video;
        } finally {
            entityManager.close();
        }
    }

    public Video findVideoWithTags(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Video video = entityManager.createQuery("select distinct v from Video v left join fetch v.tags where v.id = :id", Video.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return video;
        } finally {
            entityManager.close();
        }
    }
}
