package PL;

import Data.CustomerCentricMenu;

import java.util.Scanner;

import BLL.CommonAction.Action;

public class CustomerPage extends BankPage {

    public void printMenu() {
        Scanner scanner = new Scanner(System.in);
        for (CustomerCentricMenu menuDetails : CustomerCentricMenu.values()) {
            System.out.println(menuDetails.sequenceNumber + ". " + menuDetails.description);
        }
        System.out.print("Enter any Number between 1-7 to perform appropriate action:");
        String input = scanner.next();
        System.out.println("");
        int choiceNumber = 0;
        try {
            choiceNumber = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
        if (choiceNumber > 0) {

            if (choiceNumber == 1 || choiceNumber >= 6) {
                Action customerAction = CustomerCentricMenu.getActionFromSequence.get(choiceNumber).getCustomerActions();
                System.out.print("Action of selected option: ");
                customerAction.performAction();
            } else {
                Action commonAction = CustomerCentricMenu.getActionFromSequence.get(choiceNumber).getCustomerActions();
                System.out.print("Action of selected option: ");
                commonAction.performAction();
            }
        }
        printMenu();
    }
}
