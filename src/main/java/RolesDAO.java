public interface RolesDAO {
    void mergeRoles(Roles roles);

    void saveRoles(Roles roles);

    void deleteRoles(Roles roles);


    void flushRoles();
}
