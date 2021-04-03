package PresentationLayer.MenuRouting;

public interface IMenuRoutingCommand {
    void setUserRole(String userRole);

    void execute();
}
