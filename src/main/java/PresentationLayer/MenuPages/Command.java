package PresentationLayer.MenuPages;

public abstract class Command implements ICommand {
    private String userRole = "";

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public abstract void execute();
}
