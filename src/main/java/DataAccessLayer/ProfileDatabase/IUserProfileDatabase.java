package DataAccessLayer.ProfileDatabase;

public interface IUserProfileDatabase {
    void validateUser(String username, int password);

    int addNewUser(String userName, String defaultPassword, String userRole);

    void updateUserPassword(String userName, int changedPassword);
}
