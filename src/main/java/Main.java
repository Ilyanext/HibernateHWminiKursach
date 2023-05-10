import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
//        Roles roles= new Roles();
//        roles.printChangeRole(Role.DEVELOPER);
//        User user = new User("Ilya", "loginn",123, new HashSet<>(roles.printChangeRole(roles)));
//        RolesDAO rolesDAO= new RolesDAOImpl();
//        UserDAO userDAO = new UserDAOImpl();
//
//        rolesDAO.saveRoles(roles);
//        userDAO.saveUser(user);
        RolesDAO rolesDAO=new RolesDAOImpl();
        UserDAO userDAO=new UserDAOImpl();

        Roles roles1 = new Roles();
        roles1.printChangeRole(Role.DEVELOPER);
        rolesDAO.saveRoles(roles1);

        Roles roles2 = new Roles();
        roles2.printChangeRole(Role.ANALYST);
        rolesDAO.saveRoles(roles2);
        rolesDAO.flushRoles();

        User user1=new User("Ilya", "loginn",123);
        user1.addRole(roles1);
        user1.addRole(roles2);

        userDAO.saveUser(user1);


    }
}
