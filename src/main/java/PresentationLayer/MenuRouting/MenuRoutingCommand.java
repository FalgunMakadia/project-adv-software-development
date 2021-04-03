package PresentationLayer.MenuRouting;

public abstract class MenuRoutingCommand implements IMenuRoutingCommand {
    private String userRole = "";

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public abstract void execute();
}
