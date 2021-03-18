package PresentationLayer.CommonPages;

import PresentationLayer.MenuPages.BankEmployeePage;
import PresentationLayer.MenuPages.BankManagerPage;
import PresentationLayer.MenuPages.CustomerPage;
import PresentationLayer.MenuPages.Page;

import java.util.HashMap;
import java.util.Map;

public enum LoginRouting {
    CUSTOMER("C", "Update Personal Details",  new CustomerPage()),
    EMPLOYEE("E", "Withdraw", new BankEmployeePage()),
    MANGER("M", "Deposit", new BankManagerPage());

    private String userRole;
    private String description;
    private Page menuPage;

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
