package PresentationLayer.UserPages;

import java.util.Scanner;

import PresentationLayer.Page;

public class CustomerPage extends Page {

    public CustomerPage(){
        super();
    }
    public void printMenu() {
        System.out.println("Welcome " + loggedInUserContext.getUserName() + "!");
        System.out.println();
        while (loggedInUserContext.getLoginStatus()) {
            Scanner scanner = new Scanner(System.in);
            for (CustomerMenu menuDetails : CustomerMenu.values()) {
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
                Page customerAction = CustomerMenu.getActionFromSequence.get(choiceNumber).getCustomerActions();
                customerAction.printMenu();
            }
        }
    }
}
