package org.training360.week03.day01.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDaoTest {

    UserDao userDao;

    EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        userDao = new UserDao(entityManagerFactory);
    }

    @Test
    void testSaveUser(){
        User user = new User("John", LocalDate.of(2021,11,11));
//        user.addVideo("My second video");
        user.addVideo(new Video("My second video", LocalTime.of(0, 2, 3)));

        userDao.saveUser(user);

        User other = userDao.findUser(user.getId());

        assertEquals("John", other.getName());
        assertEquals(LocalDate.of(2021, 11, 11), other.getRegistrationDate());
        assertEquals(1, user.getVideos().size());
//        assertNull(other.getVideos());
    }

    @Test
    void testFindUserWithVideos() {
        User user = new User("John", LocalDate.of(2021,11,11));

        userDao.saveUser(user);
//        userDao.saveVideoToUser(user.getId(), "My first video");
        userDao.saveVideoToUser(user.getId(), new Video("My first video", LocalTime.of(1, 23, 31)));

        User other = userDao.findUserWithVideos(user.getId());

        assertEquals("John", other.getName());
        assertEquals(LocalDate.of(2021, 11, 11), other.getRegistrationDate());
        assertEquals(1, other.getVideos().size());
    }

//    @Test
//    void testSaveThanFind() {
//        User user = new User("John", LocalDate.of(2021,11,11));
//        userDao.saveUser(user);
//        User other = userDao.findUser(user.getId());
//        other.addVideo("My third video");
//        userDao.saveUser(other);
//    }

//    @Test
//    void testWithEntityManager() {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        User user = new User("John", LocalDate.of(2021,11,11));
//        entityManager.persist(user);
//        entityManager.getTransaction().commit();
//
//        entityManager.getTransaction().begin();
//        user.addVideo("My fourth video");
//        entityManager.getTransaction().commit();
//
//        entityManager.close();
//    }
}