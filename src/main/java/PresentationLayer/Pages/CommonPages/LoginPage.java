package PresentationLayer.Pages.CommonPages;

import BusinessLogicLayer.CommonAction.ISignInAction;
import BusinessLogicLayer.ActionFactory;
import PresentationLayer.MenuRouting.BankEmployeeMenuRoutingCommand;
import PresentationLayer.MenuRouting.BankManagerMenuRoutingCommand;
import PresentationLayer.MenuRouting.CustomerMenuRoutingCommand;
import PresentationLayer.MenuRouting.IMenuRoutingCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginPage implements ILoginPage {

    private static final String BANK_EMPLOYEE_USER_ROLE = "E";
    private static final String BANK_MANAGER_USER_ROLE = "M";
    private static final String CUSTOMER_USER_ROLE = "C";
    private static final boolean APPLICATION_RUN_STATUS = true;

    private String username;
    private String password;
    private Map<String, IMenuRoutingCommand> menuRoutingCommandMap;

    public LoginPage() {
        menuRoutingCommandMap = new HashMap<>();
        menuRoutingCommandMap.put(BANK_EMPLOYEE_USER_ROLE, new BankEmployeeMenuRoutingCommand());
        menuRoutingCommandMap.put(BANK_MANAGER_USER_ROLE, new BankManagerMenuRoutingCommand());
        menuRoutingCommandMap.put(CUSTOMER_USER_ROLE, new CustomerMenuRoutingCommand());
    }

    public void takeLoginCredential() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Username:");
            username = scanner.nextLine();
            System.out.print("Password:");
            password = scanner.nextLine();
            System.out.println("Logging In...");
            ActionFactory actionFactory = new ActionFactory();
            ISignInAction login = actionFactory.createLogin();
            login.validateUser(username, password);
            if (login.checkStatus()) {
                System.out.println("Successfully Logged In");
                System.out.println();
                System.out.println("********========================================********");
                System.out.println();
                routeToMenu(login.getUserRole());
            } else {
                System.out.println("Login Failed!");
                System.out.println("No Active Profile Found.");
                System.out.println("Please Try Again.");
            }
        } while (APPLICATION_RUN_STATUS);
    }

    private void routeToMenu(String userRole) {
        IMenuRoutingCommand menuRoutingCommand = menuRoutingCommandMap.get(userRole);
        menuRoutingCommand.execute();
    }
}