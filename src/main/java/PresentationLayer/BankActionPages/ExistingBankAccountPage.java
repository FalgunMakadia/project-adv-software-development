package PresentationLayer.BankActionPages;

import BLL.CommonAction.Action;
import PresentationLayer.Page;

import java.util.Scanner;

public class ExistingBankAccountPage extends Page {
    private String accountNumber;

    @Override
    public void printMenu() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Account Number:");
        accountNumber = scanner.nextLine();
        System.out.println("");        for (ExistingBankAccountMenu menuDetails : ExistingBankAccountMenu.values()) {
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
