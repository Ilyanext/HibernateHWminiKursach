import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="idUsers")
@Builder
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
    private LocalDateTime createTime;
    @Column(name = "data_modific", nullable = false)
    private LocalDateTime mergeTime;

    @ManyToMany( cascade = CascadeType.MERGE)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "users_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "roles_id", referencedColumnName = "id")}
    )
    private Set<Roles> roles=new HashSet<>();





}
