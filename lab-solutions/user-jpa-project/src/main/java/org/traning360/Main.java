package org.traning360;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.traning360.user.*;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");

        UserRepository repository = new UserRepository(factory);
        UserService service = new UserService(repository);

        service.saveUser("dsad","1234", Role.USER);

        repository.updateUserWithContent(1L, new Content("video1",12, LocalDate.parse("2023-02-01")));

    }
}