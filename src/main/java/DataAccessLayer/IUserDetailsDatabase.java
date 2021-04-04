package DataAccessLayer;

public interface IUserDetailsDatabase {
    void validateUser(String username, int password);

    int addNewUser(String userName, String defaultPassword, String userRole);

    void updateUserPassword(String userName, int changedPassword);
}
