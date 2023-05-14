import javax.management.relation.Role;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static UserDAO userDAO = new UserDAOImpl();
    static RolesDAO rolesDAO = new RolesDAOImpl();
    public static void main(String[] args) {

        Roles developer = Roles.builder().roleType(RoleType.DEVELOPER).build();
        Roles analyst = Roles.builder().roleType(RoleType.ANALYST).build();
        Roles tester = Roles.builder().roleType(RoleType.TESTER).build();

        rolesDAO.saveRoles(developer);
        rolesDAO.saveRoles(analyst);
        rolesDAO.saveRoles(tester);


        Set<Roles> roles = new HashSet<>();
        roles.add(rolesDAO.getByID(1));
        User newUser =User.builder().nameUsers("Ilya").loginUsers("rtyu").passwordUsers(12354).createTime(LocalDateTime.now()).mergeTime(LocalDateTime.now()).roles(roles).build();
        User newUser2 = userDAO.saveUser(newUser);
        roles.add(rolesDAO.getByID(2));
        newUser2.setRoles(roles);
        userDAO.mergeUser(newUser2);

    }
}
