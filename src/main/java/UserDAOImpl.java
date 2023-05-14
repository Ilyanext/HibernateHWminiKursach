import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public User mergeUser(User user) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.merge(user);

        transaction.commit();
        entityManager.close();
        return user;
    }

    @Override
    public User saveUser(User user) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(user);

        transaction.commit();
        entityManager.close();
        return user;
    }

    @Override
    public void deleteUser(User user) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.remove(user);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public User getByID(int id) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        return entityManager.find(User.class,id);
    }

    @Override
    public List getAllUser() {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        return entityManager.createQuery("FROM User").getResultList();
    }

    static EntityManager createEntityManager() {
        EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("myPersistenceUnit");
        return entityManager.createEntityManager();

    }
}
