package PresentationLayer.UserPages;

import BusinessLogicLayer.CommonAction.Login;

import java.io.IOException;
import java.util.Scanner;

public class LoginPage {
    private String username;
    private String password;
    private String authLevel;

    public String getAuthLevel() {
        return authLevel;
    }

    public void takeUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username:");
        this.username = scanner.nextLine();
        System.out.print("Password:");
        this.password = scanner.nextLine();
        try {
            Login login = new Login(username, password);
        } catch (IOException e) {
            e.printStackTrace();
        }
        printUserValidityStatus(authLevel);

        if (authLevel == "E") {
            BankEmployeePage bankEmployeePage = new BankEmployeePage();
            bankEmployeePage.printMenu();
        }
        else if (authLevel == "C") {
            CustomerPage customerPage = new CustomerPage();
            customerPage.printMenu();
        }
        else if (authLevel == "M") {
            BankManagerPage bankManagerPage = new BankManagerPage();
            bankManagerPage.printMenu();
        }
        else {
            System.out.println("NO AUTHORIZATION");
        }
    }

    public void printUserValidityStatus(String isValid) {
        if (isValid == "C") {
            System.out.println("Valid User : Customer");
        }
        else if (isValid == "E") {
            System.out.println("Valid User : Bank Employee");
        }
        else if (isValid == "M") {
            System.out.println("Valid User : Bank Manager");
        }
        else {
            System.out.println("Invalid User");
        }
    }
}
