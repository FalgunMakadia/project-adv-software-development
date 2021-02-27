package PL;

import BLL.BankAction.BankActions;
import data.BankCentricMenu;

import java.util.Scanner;

public class MenuInterface {
    public static void main(String[] args) {

//        Login Page
        Login loginPage = new Login();
        loginPage.takeUserInput();

        BLL.Login login  = new BLL.Login(loginPage.getUsername(), loginPage.getPassword());
        Boolean isUserValid = login.validUser();

        loginPage.printUserValidityStatus(isUserValid);
//        int tmp = sc.nextInt();
//        BankActions bankActions = BankCentricMenu.getActionFromSequence.get(tmp).getAction();

//        bankActions.performAction();
//
//        for(BankCentricMenu bankCentricMenu:BankCentricMenu.values()){
//            System.out.println(bankCentricMenu.sequenceNumber + ". " + bankCentricMenu.description);
//        }

    }
}
