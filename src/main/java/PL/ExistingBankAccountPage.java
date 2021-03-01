package PL;

import BLL.CommonAction.Action;
import Data.ExistingBankAccountMenu;

import java.util.Scanner;

public class ExistingBankAccountPage extends BankPage {
    @Override
    public void printMenu() {

        Scanner scanner = new Scanner(System.in);
        for (ExistingBankAccountMenu menuDetails : ExistingBankAccountMenu.values()) {
            System.out.println(menuDetails.getSequenceNumber() + ". " + menuDetails.getDescription());
        }
        System.out.print("Enter any Number between 1-4 to perform appropriate action:");
        String input = scanner.next();
        System.out.println("");
        int choiceNumber = 0;
        try {
            choiceNumber = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
        if (choiceNumber > 0) {
            Action action = ExistingBankAccountMenu.getActionFromSequence.get(choiceNumber).getAction();
            System.out.print("Action of selected option: ");
            action.performAction();
        } else {
            printMenu();
        }
    }

}
