package PL;

public class App {
    public static void main(String[] args) {

//      Login Page
        LoginPage loginPage = new LoginPage();
        loginPage.takeUserInput();

        BLL.Login login = new BLL.Login(loginPage.getUsername(), loginPage.getPassword(), loginPage.getAuthLevel());
        String isUserValid = login.validUser();

        loginPage.printUserValidityStatus(isUserValid);

        if (isUserValid == "E") {
            BankEmployeePage bankPage = new BankEmployeePage();
            bankPage.printMenu();
        } else if (isUserValid == "C") {
            CustomerPage customerPage = new CustomerPage();
            customerPage.printMenu();
        } else {
            System.out.println("NO AUTHORIZATION");
        }
    }
}