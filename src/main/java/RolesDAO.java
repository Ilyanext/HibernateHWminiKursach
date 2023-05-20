import javax.management.relation.Role;
import java.util.List;

public interface RolesDAO {
    Roles mergeRoles(Roles roles);

    Roles saveRoles(Roles roles);

    void deleteRoles(Roles roles);


    Roles getByID(int id);

    List<Roles> getAllRoles();

}
