package PL;

public class App {
    public static void main(String[] args) {

//        Login Page
        LoginPage loginPage = new LoginPage();
        loginPage.takeUserInput();

        BLL.Login login  = new BLL.Login(loginPage.getUsername(), loginPage.getPassword());
        Boolean isUserValid = login.validUser();

        loginPage.printUserValidityStatus(isUserValid);

        BankEmployeePage bankPage = new BankEmployeePage();

        if(isUserValid) {
            bankPage.printMenu();
        }
//        int tmp = sc.nextInt();
//        BankActions bankActions = BankCentricMenu.getActionFromSequence.get(tmp).getAction();

//        bankActions.performAction();
//
//        for(BankCentricMenu bankCentricMenu:BankCentricMenu.values()){
//            System.out.println(bankCentricMenu.sequenceNumber + ". " + bankCentricMenu.description);
//        }

    }
}
