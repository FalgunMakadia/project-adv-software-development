package PresentationLayer.BankActionPages;

import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.User.User;
import BusinessLogicLayer.Factory;
import PresentationLayer.Page;
import BusinessLogicLayer.ActionFactory;

import java.util.Scanner;

public class OpenNewAccountPage extends Page {

    private User customer = null;
    @Override
    public void printMenu() {
        System.out.println("Please enter the details of following fields:");
        System.out.println("Note: (*) are mandatory fields.");
        Factory actionFactory = new ActionFactory();

        customer = actionFactory.createCustomer();
        getAccountDetails();
        System.out.println();
        System.out.println("Please verify the details.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println("");
        int choiceNumber = 0;
        try {
            choiceNumber = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
        if(choiceNumber > 0  && choiceNumber <14){

        }

        Action action =  actionFactory.createNewOpenNewAccount();
        action.performAction();

    }

    private void getAccountDetails(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("First Name*: ");
        customer.setFirstName(scanner.nextLine());
        System.out.print("Last Name*: ");
        customer.setLastName(scanner.nextLine());
        System.out.print("Middle Name: ");
        customer.setMiddleName(scanner.nextLine());
        System.out.print("Address Line 1*: ");
        customer.setAddressLine1(scanner.nextLine());
        System.out.print("Address Line 2: ");
        customer.setAddressLine2(scanner.nextLine());
        System.out.print("City*: ");
        customer.setCity(scanner.nextLine());
        System.out.print("State/ Province*: ");
        customer.setProvince(scanner.nextLine());
        System.out.print("Postal Code*: ");
        customer.setPostalCode(scanner.nextLine());
        System.out.print("Email Address*: ");
        customer.setEmailAddress(scanner.nextLine());
        System.out.print("Contact Number*: ");
        customer.setContact(scanner.nextLine());
        System.out.print("Passport Number*: ");
        customer.setPassport(scanner.nextLine());
        System.out.print("SSN*: ");
        customer.setSsnNo(scanner.nextLine());
        System.out.println("1. Save ");
        System.out.println("2. Restart");
        System.out.println("3. Back to Main Menu");
        System.out.println("Please enter number between 1-3 to perform appropriate action");
        String input = scanner.nextLine();


    }



}
