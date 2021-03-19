package PresentationLayer.MenuPages;

public abstract class Command {
    private String userRole = "";
    public void setUserRole(String userRole){
        this.userRole = userRole;
    }
    public abstract void execute();
}
