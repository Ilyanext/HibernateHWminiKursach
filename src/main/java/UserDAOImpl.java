import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserDAOImpl implements UserDAO {
    @Override
    public void mergeUser(User user) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.merge(user);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public void saveUser(User user) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(user);

        transaction.commit();
        entityManager.close();
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

    static EntityManager createEntityManager() {
        EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("myPersistenceUnit");
        return entityManager.createEntityManager();

    }
}
