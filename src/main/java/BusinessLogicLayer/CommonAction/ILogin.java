package BusinessLogicLayer.CommonAction;

public interface ILogin {
    void validateUser(String userName, String Password);
    boolean checkStatus();
    String getUserRole();
}
