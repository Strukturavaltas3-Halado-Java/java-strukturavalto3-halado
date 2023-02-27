package user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserDao2Test {

    UserDao2 userDao;

    @BeforeEach
    void init() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        PersistenceContextHandler persistenceContextHandler = new PersistenceContextHandler(entityManagerFactory);
        userDao = new UserDao2(persistenceContextHandler);
    }

    @Test
    void testSaveUser() {
        User user = new User("John", LocalDate.of(2021,11,11));

        userDao.saveUser(user);

        User other = userDao.findUser(user.getId());

        assertEquals("John", other.getName());
        assertEquals(LocalDate.of(2021, 11, 11), other.getRegistrationDate());
    }
}