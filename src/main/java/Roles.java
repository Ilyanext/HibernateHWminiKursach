import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(of="idRoles")
@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int idRoles;

    @Enumerated (EnumType.STRING)
    private RoleType roleType;
    @ManyToMany( cascade = CascadeType.MERGE)
    private Set<User> users=new HashSet<>();



//    public Role printChangeRole(Role role) {
//        switch (role) {
//            case TESTER:
//                Role roles = Role.valueOf("TESTER");
//                return roles;
//            case ANALYST:
//                roles = Role.valueOf("ANALYST");
//                return roles;
//            case MANAGER:
//                roles = Role.valueOf("MANAGER");
//                return roles;
//            case DESIGNER:
//                roles = Role.valueOf("DESIGNER");
//                return roles;
//            case DEVELOPER:
//                roles = Role.valueOf("DEVELOPER");
//                return roles;
//            default:
//                roles = Role.valueOf("DEFAULT");
//                return roles;
//        }
//    }




}
