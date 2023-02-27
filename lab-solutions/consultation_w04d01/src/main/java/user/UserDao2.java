package user;

public class UserDao2 {

    private PersistenceContextHandler handler;

    public UserDao2(PersistenceContextHandler handler) {
        this.handler = handler;
    }

    public void saveUser(User user) {
        handler.doInTransaction(entityManager -> entityManager.persist(user));
    }

    public User findUser(long id) {
        return handler.query(entityManager -> entityManager.find(User.class, id));
    }
}
