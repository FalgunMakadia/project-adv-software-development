package PL.Bank;

import java.util.Scanner;

import BLL.CommonAction.Action;
import PL.Page;

public class BankEmployeePage extends Page {
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
        String actionFlag = "";
        if (choiceNumber > 0) {
            Page page = BankEmployeeMenu.getActionFromSequence.get(choiceNumber).getAction();
            System.out.print("Action of selected option: ");
            page.printMenu();

        }

            printMenu();

    }
}
