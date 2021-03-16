package PresentationLayer.UserPages;

import PresentationLayer.Page;

import java.util.HashMap;
import java.util.Map;

public enum LoginRouting {
    CUSTOMER("C", "Update Personal Details",  new CustomerPage()),
    EMPLOYEE("E", "Withdraw", new BankEmployeePage()),
    MANGER("M", "Deposit", new BankManagerPage());

    public String userRole;
    public String description;
    public Page menuPage;

    public String getUserRole() {
        return userRole;
    }

    public String getDescription() {
        return description;
    }

    public Page getMenuPage() { return menuPage; }


    LoginRouting(String number, String desc, Page page){
        this.userRole = number;
        this.description = desc;
        this.menuPage = page;
    }


    public static Map<String, LoginRouting> getActionFromSequence = new HashMap();

    static {
        for(LoginRouting menuPage : LoginRouting.values()) {
            getActionFromSequence.put(menuPage.getUserRole(),menuPage);
        }
    }

}
