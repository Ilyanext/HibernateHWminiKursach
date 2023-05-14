import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class RolesDAOImpl implements RolesDAO{
    @Override
    public Roles mergeRoles(Roles roles) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.merge(roles);

        transaction.commit();
        entityManager.close();
        return roles;
    }

    @Override
    public Roles saveRoles(Roles roles) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(roles);

        transaction.commit();
        entityManager.close();
        return roles;

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
    public Roles getByID(int id) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

       return entityManager.find(Roles.class,id);

    }

    @Override
    public List getAllRoles() {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        return entityManager.createQuery("FROM Roles").getResultList();
    }


    static EntityManager createEntityManager(){
        EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("myPersistenceUnit");
                return entityManager.createEntityManager();

    }
}
