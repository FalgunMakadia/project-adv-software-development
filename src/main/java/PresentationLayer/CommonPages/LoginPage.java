package PresentationLayer.CommonPages;

import BusinessLogicLayer.CommonAction.ILogin;
import BusinessLogicLayer.ActionFactory;
import PresentationLayer.MenuPages.BankManagerCommand;
import PresentationLayer.MenuPages.Command;
import PresentationLayer.MenuPages.CustomerCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginPage {
    private String username;
    private String password;
    private Map<String,Command> route;
    public LoginPage(){
        route = new HashMap<>();
        route.put("E", new BankManagerCommand());
        route.put("M", new BankManagerCommand());
        route.put("C", new CustomerCommand());
    }
    public void takeUserInput() {
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
       Command command = route.get(userRole);
       command.execute();
    }


}
