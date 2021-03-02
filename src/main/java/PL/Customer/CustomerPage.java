package PL.Customer;

import java.util.Scanner;

import BLL.CommonAction.Action;
import PL.Page;

public class CustomerPage extends Page {

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

        String actionFlag = "";
        if (choiceNumber > 0) {
            Action customerAction = CustomerCentricMenu.getActionFromSequence.get(choiceNumber).getCustomerActions();
            System.out.print("Action of selected option: ");
            customerAction.performAction();
        }
        if (actionFlag.length() > 0) {
            printMenu();
        }
    }
}
