package PresentationLayer.Pages.CommonPages;

import BusinessLogicLayer.CommonAction.ILogin;
import BusinessLogicLayer.ActionFactory;
import PresentationLayer.MenuRouting.BankEmployeeMenuRoutingCommand;
import PresentationLayer.MenuRouting.BankManagerMenuRoutingCommand;
import PresentationLayer.MenuRouting.CustomerMenuRoutingCommand;
import PresentationLayer.MenuRouting.IMenuRoutingCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginPage implements ILoginPage{
    private String username;
    private String password;
    private Map<String, IMenuRoutingCommand> menuRoutingCommandMap;
    public LoginPage() {
        menuRoutingCommandMap = new HashMap<>();
        menuRoutingCommandMap.put("E", new BankEmployeeMenuRoutingCommand());
        menuRoutingCommandMap.put("M", new BankManagerMenuRoutingCommand());
        menuRoutingCommandMap.put("C", new CustomerMenuRoutingCommand());
    }
    public void takeLoginCredential() {
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.print("Username:");
            username = scanner.nextLine();
            System.out.print("Password:");
            password = scanner.nextLine();
            System.out.println("Logging In...");
            ActionFactory actionFactory =  new ActionFactory();
            ILogin login = actionFactory.createLogin();
            login.validateUser(username,password);
            if(login.checkStatus()){
                System.out.println("Successfully Logged In");
                System.out.println();
                System.out.println("********========================================********");
                System.out.println();
                routeToMenu(login.getUserRole());
            }
            else{
                System.out.println("Login Failed!");
                System.out.println("No Active ProfileAbstract Found.");
                System.out.println("Please Try Again.");
            }
        }while (true);

    }

    private void routeToMenu(String userRole){
       IMenuRoutingCommand menuRoutingCommand = menuRoutingCommandMap.get(userRole);
       menuRoutingCommand.execute();
    }


}
