package PL;

import Data.BankEmployeeMenu;

import java.util.Scanner;

import BLL.CommonAction.Action;

public class BankEmployeePage extends BankPage {
    @Override
    public void printMenu() {
        Scanner scanner = new Scanner(System.in);
        for (BankEmployeeMenu menuDetails : BankEmployeeMenu.values()) {
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
            Action action = BankEmployeeMenu.getActionFromSequence.get(choiceNumber).getAction();
            BankPage subMenu = BankEmployeeMenu.getActionFromSequence.get(choiceNumber).getSubMenu();
            System.out.print("Action of selected option: ");
            if (action != null) {
                action.performAction();
            } else {
                subMenu.printMenu();
            }
        }
        printMenu();
    }
}
