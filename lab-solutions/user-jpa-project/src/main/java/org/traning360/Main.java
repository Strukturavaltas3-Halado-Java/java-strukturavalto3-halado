package org.traning360;

import org.traning360.user.Role;
import org.traning360.user.User;
import org.traning360.user.UserRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");

        UserRepository repository = new UserRepository(factory);

        User saved= repository.saveUser(new User("dsad","1234", Role.USER));

        repository.updateUserPassword("dsad","1235");

    }
}