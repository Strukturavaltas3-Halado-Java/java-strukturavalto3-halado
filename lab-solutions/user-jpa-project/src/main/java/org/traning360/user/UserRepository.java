package org.traning360.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;


import java.util.Map;

public class UserRepository {

    private EntityManagerFactory factory;

    public UserRepository(EntityManagerFactory factory) {
        this.factory = factory;

    }

    public User saveUser(User user){
        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(user);
            manager.getTransaction().commit();
            return user;
        }finally {
            manager.close();
        }
    }

    public User findUserById(long id){
        EntityManager entityManager = factory.createEntityManager();
        try{
            return entityManager.find(User.class,id);
        }finally {
            entityManager.close();
        }
    }

    public User findUserByUserName(String username){
        EntityManager entityManager = factory.createEntityManager();
        try{
            return entityManager.createQuery(
                    "select u from User u where u.username=?1",User.class)
                    .setParameter(1, username)
                    .getSingleResult();
        }finally {
            entityManager.close();
        }
    }

    public void updateUserPassword(String username, String newPassword){
        EntityManager entityManager = factory.createEntityManager();

        try{
            entityManager.getTransaction().begin();
             User user = entityManager.createQuery(
                            "select u from User u where u.username=?1",User.class)
                    .setParameter(1, username)
                    .getSingleResult();
             user.setPassword(newPassword);
             entityManager.getTransaction().commit();

        }finally {
            entityManager.close();
        }
    }
}
