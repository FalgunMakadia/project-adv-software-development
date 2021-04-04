package BusinessLogicLayer.User;

public class CustomerProfile extends AbstractProfile {
    private static final String customerUserRole = "C";
    public CustomerProfile() {
        super();
    }

    @Override
    public String getProfileRole() {
        return customerUserRole;
    }
}


