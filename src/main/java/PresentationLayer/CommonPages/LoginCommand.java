package PresentationLayer.CommonPages;

import PresentationLayer.MenuPages.IPage;

import java.util.HashMap;
import java.util.Map;

public enum LoginCommand {;
//    CUSTOMER("C", "Update Personal Details",  new MenuPage()),
//    EMPLOYEE("E", "Withdraw", new BankEmployeePage()),
//    MANGER("M", "Deposit", new BankManagerPage());

    private String userRole;
    private String description;
    private IPage menuPage;

    public String getUserRole() {
        return userRole;
    }

    public String getDescription() {
        return description;
    }

    public IPage getMenuPage() { return menuPage; }


    LoginCommand(String number, String desc, IPage page){
        this.userRole = number;
        this.description = desc;
        this.menuPage = page;
    }


    public static Map<String, LoginCommand> getActionFromSequence = new HashMap();

    static {
        for(LoginCommand menuPage : LoginCommand.values()) {
            getActionFromSequence.put(menuPage.getUserRole(),menuPage);
        }
    }

}
