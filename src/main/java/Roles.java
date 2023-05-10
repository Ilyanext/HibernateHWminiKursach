import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int idRoles;

    @Column(name = "role", nullable = false)
    private String role;
    @ManyToMany( )
    private Set<User> users=new HashSet<>();

    public Roles(String role) {
        this.role = role;
    }
    public void addUser(User user){
        this.users.add(user);

    }
    public void removeUser(User user){
        this.users.remove(user);
    }
    public Role printChangeRole(Role role) {
        switch (role) {
            case TESTER:
                Role roles = Role.valueOf("TESTER");
                return roles;
            case ANALYST:
                roles = Role.valueOf("ANALYST");
                return roles;
            case MANAGER:
                roles = Role.valueOf("MANAGER");
                return roles;
            case DESIGNER:
                roles = Role.valueOf("DESIGNER");
                return roles;
            case DEVELOPER:
                roles = Role.valueOf("DEVELOPER");
                return roles;
            default:
                roles = Role.valueOf("DEFAULT");
                return roles;
        }
    }

    public Roles() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roles roles = (Roles) o;
        return idRoles == roles.idRoles && Objects.equals(role, roles.role) && Objects.equals(users, roles.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRoles, role, users);
    }

    public void setIdRoles(int id) {
        this.idRoles = id;
    }

    public int getIdRoles() {
        return idRoles;
    }

}
