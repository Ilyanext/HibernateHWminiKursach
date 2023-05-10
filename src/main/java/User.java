import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idUsers;

    @Column(name = "name", nullable = false)
    private String nameUsers;
    @Column(name = "login", nullable = false)
    private String loginUsers;
    @Column(name = "password", nullable = false)
    private int passwordUsers;
    @Column(name = "data", nullable = false)
    private LocalDateTime localDateTime;


    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "users_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "roles_id", referencedColumnName = "id")}
    )
    private Set<Roles> roles=new HashSet<>();
    public void addRole(Roles role){
        this.roles.add(role);

    }
    public void removeRole(Roles role){
        this.roles.remove(role);
    }
    public User( String nameUsers, String loginUsers, int passwordUsers,  Set<Roles> roles) {

        this.nameUsers = nameUsers;
        this.loginUsers = loginUsers;
        this.passwordUsers = passwordUsers;
        this.roles = roles;
    }
    public User( String nameUsers, String loginUsers, int passwordUsers) {

        this.nameUsers = nameUsers;
        this.loginUsers = loginUsers;
        this.passwordUsers = passwordUsers;
    }
    public String getNameUsers() {
        return nameUsers;
    }


    public void setNameUsers(String name) {
        this.nameUsers = name;
    }

    public String getLoginUsers() {
        return loginUsers;
    }

    public void setLoginUsers(String login) {
        this.loginUsers = login;
    }

    public int getPasswordUsers() {
        return passwordUsers;
    }

    public void setPasswordUsers(int password) {
        this.passwordUsers = password;
    }

    public User() {

    }

    public void setIdUsers(int id) {

        this.idUsers = id;
    }

    public int getIdUsers() {
        return idUsers;
    }
}
