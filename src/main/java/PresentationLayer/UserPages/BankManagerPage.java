package PresentationLayer.UserPages;

import BusinessLogicLayer.CommonAction.Action;
import PresentationLayer.Page;

import java.util.Scanner;

public class BankManagerPage extends Page {
    @Override
    public void printMenu() {
        Scanner scanner = new Scanner(System.in);
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
            Action action = BankManagerMenu.getActionFromSequence.get(choiceNumber).getAction();
            Page subMenu = BankManagerMenu.getActionFromSequence.get(choiceNumber).getSubMenu();
            actionFlag = BankManagerMenu.getActionFromSequence.get(choiceNumber).getActionFlag();
            System.out.print("Action of selected option: ");
            if (action != null) {
                action.performAction();
            } else {
                subMenu.printMenu();
            }
        }
        System.out.println();
        if(actionFlag.length() > 0){
            printMenu();
        }

    }

}
