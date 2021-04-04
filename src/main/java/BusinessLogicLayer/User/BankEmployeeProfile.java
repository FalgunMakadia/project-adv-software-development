package BusinessLogicLayer.User;

public class BankEmployeeProfile extends AbstractProfile {
    private static final String bankEmployeeUserRole = "E";
    @Override
    public String getProfileRole() {
        return bankEmployeeUserRole;
    }
}
