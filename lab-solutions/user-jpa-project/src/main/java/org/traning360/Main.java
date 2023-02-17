package org.traning360;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.traning360.user.Role;
import org.traning360.user.User;
import org.traning360.user.UserRepository;
import org.traning360.user.UserService;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");

        UserRepository repository = new UserRepository(factory);
        UserService service = new UserService(repository);

        service.saveUser("dsad","1234", Role.USER);

        System.out.println(service.signInUser("dsad","4231"));

    }
}