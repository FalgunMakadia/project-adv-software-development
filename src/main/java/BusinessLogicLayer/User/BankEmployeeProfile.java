package BusinessLogicLayer.User;

public class BankEmployeeProfile extends ProfileAbstract {
    private static final String bankEmployeeUserRole = "E";
    @Override
    public String getProfileRole() {
        return bankEmployeeUserRole;
    }
}
