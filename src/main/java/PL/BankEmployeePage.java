package PL;

import BLL.BankAction.BankActions;
import data.BankCentricMenu;

import java.util.Scanner;

public class BankEmployeePage {
    Scanner scanner = new Scanner(System.in);
    public void printMenu() {
        for(BankCentricMenu menuDetails: BankCentricMenu.values()) {
            System.out.println(menuDetails.sequenceNumber + ". " + menuDetails.description);
        }
        System.out.print("Enter any Number between 1-5 to perform appropriate action:");
        int choiceNumber = scanner.nextInt();
        BankActions action = BankCentricMenu.getActionFromSequence.get(choiceNumber).getAction();
        System.out.print("Action of selected option: ");
        action.performAction();
    }
}
