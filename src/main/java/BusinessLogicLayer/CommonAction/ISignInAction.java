package BusinessLogicLayer.CommonAction;

public interface ISignInAction {
    void validateUser(String userName, String Password);
    boolean checkStatus();
    String getUserRole();
}
