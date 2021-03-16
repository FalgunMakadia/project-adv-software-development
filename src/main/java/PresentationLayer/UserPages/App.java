package PresentationLayer.UserPages;

import BusinessLogicLayer.CommonAction.Login;

public class App {
    public static void main(String[] args) {

//      Login Page
        LoginPage loginPage = new LoginPage();
        loginPage.takeUserInput();
        System.out.println("Logging In...");



    }
}