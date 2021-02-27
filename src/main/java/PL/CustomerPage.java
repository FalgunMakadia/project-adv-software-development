package PL;

import BLL.BankAction.BankActions;
import BLL.CommonAction.CommonActions;
import BLL.CustomerAction.CustomerActions;
import data.CustomerCentricMenu;

import java.util.Scanner;

public class CustomerPage {
    Scanner scanner = new Scanner(System.in);

    public void printMenu() {
        for(CustomerCentricMenu menuDetails: CustomerCentricMenu.values()) {
            System.out.println(menuDetails.sequenceNumber + ". " + menuDetails.description);
        }
        System.out.print("Enter any Number between 1-7 to perform appropriate action:");
        int choiceNumber = scanner.nextInt();

        if(choiceNumber == 1 || choiceNumber >= 6) {
            CustomerActions customerAction = CustomerCentricMenu.getActionFromSequence.get(choiceNumber).getCustomerActions();
            System.out.print("Action of selected option: ");
            customerAction.performAction();
        } else {
            CommonActions commonAction =  CustomerCentricMenu.getActionFromSequence.get(choiceNumber).getCommonActions();
            System.out.print("Action of selected option: ");
            commonAction.performAction();
        }
    }
}
