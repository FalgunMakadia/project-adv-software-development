package PresentationLayer.UserPages;

import BusinessLogicLayer.CommonAction.ILogin;
import BusinessLogicLayer.ActionFactory;
import PresentationLayer.Page;

import java.util.Scanner;

public class LoginPage {
    private String username;
    private String password;
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
                System.out.println("No Active User Found.");
                System.out.println("Please Try Again.");
            }
        }while (true);

    }

    private void routeToMenu(String userRole){
        Page menuPage = LoginRouting.getActionFromSequence.get(userRole).getMenuPage();
        menuPage.printMenu();
    }


}
