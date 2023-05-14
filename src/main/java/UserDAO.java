import java.util.List;

public interface UserDAO {
    User mergeUser(User user);

    User saveUser(User user);

    void deleteUser(User user);

    User getByID(int id);
    List<User> getAllUser();


}
