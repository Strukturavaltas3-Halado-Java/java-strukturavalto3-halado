package user;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Set;

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

    public User saveVideoToUser(long userId, long videoId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            User user = entityManager.find(User.class, userId);
            Video video = entityManager.find(Video.class, videoId);
            user.addVideo(video);
            entityManager.getTransaction().commit();
            return user;
        } finally {
            entityManager.close();
        }
    }

    public User findUserWithVideos(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            User user = entityManager.createQuery("select distinct u from User u left join fetch u.videos where u.id = :id", User.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return user;
        } finally {
            entityManager.close();
        }
    }

    public User saveCommentToUser(long userId, long commentId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            User user = entityManager.find(User.class, userId);
            Comment comment = entityManager.find(Comment.class, commentId);
            user.addComment(comment);
            entityManager.getTransaction().commit();
            return user;
        } finally {
            entityManager.close();
        }
    }

    public User findUserWithComments(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            User user = entityManager.createQuery("select distinct u from User u left join fetch u.comments where u.id = :id", User.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return user;
        } finally {
            entityManager.close();
        }
    }

    public User findUserWithVideosTagsAndComments(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            User user = entityManager.createQuery("select distinct u from User u left join fetch u.comments where u.id = :id", User.class)
                    .setParameter("id", id)
                    .getSingleResult();
            entityManager.createQuery("select distinct u from User u left join fetch u.videos where u.id = :id", User.class)
                    .setParameter("id", id)
                    .getSingleResult();
            Set<Video> videos = user.getVideos();
            entityManager.createQuery("select distinct v from Video v left join fetch v.tags where v in :videos", Video.class)
                    .setParameter("videos", videos)
                    .getResultList();
            entityManager.getTransaction().commit();
            return user;
        } finally {
            entityManager.close();
        }
    }
}
