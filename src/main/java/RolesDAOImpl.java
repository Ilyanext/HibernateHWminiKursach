import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class RolesDAOImpl implements RolesDAO{
    @Override
    public void mergeRoles(Roles roles) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.merge(roles);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public void saveRoles(Roles roles) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(roles);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public void deleteRoles(Roles roles) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.remove(roles);

        transaction.commit();
        entityManager.close();
    }
    @Override
    public void flushRoles() {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.flush();

        transaction.commit();
        entityManager.close();
    }
    static EntityManager createEntityManager(){
        EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("myPersistenceUnit");
                return entityManager.createEntityManager();

    }
}
