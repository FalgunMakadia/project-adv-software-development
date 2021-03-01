package PL;

import BLL.CommonAction.Login;

public class App {
    public static void main(String[] args) {

//      Login Page
        LoginPageInterface loginPageInterface = new LoginPageInterface();
        loginPageInterface.takeUserInput();
        System.out.println("Fetching Details...");
        Login login = new Login(loginPageInterface.getUsername(), loginPageInterface.getPassword());
        String authLevel = login.getAuthLevel();

        loginPageInterface.printUserValidityStatus(authLevel);

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
}