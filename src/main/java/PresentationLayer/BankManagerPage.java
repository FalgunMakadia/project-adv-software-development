package PresentationLayer;

import BusinessLogicLayer.CommonAction.Action;

import java.util.Scanner;

public class BankManagerPage extends Page {
    @Override
    public void printMenu() {
        Scanner scanner = new Scanner(System.in);
        while (loggedInUserContext.getLoginStatus()) {
            for (BankManagerMenu menuDetails : BankManagerMenu.values()) {
                System.out.println(menuDetails.getSequenceNumber() + ". " + menuDetails.getDescription());
            }
            System.out.print("Enter any Number between 1-5 to perform appropriate action:");
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
                Action menuPage = BankManagerMenu.getActionFromSequence.get(choiceNumber).getMenuPage();
                menuPage.performAction();
            }
        }

    }

}
