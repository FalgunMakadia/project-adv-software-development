package PL.Bank;

import BLL.User.Customer;
import PL.Page;

import java.util.Scanner;

public class OpenNewAccountPage extends Page {

    private Customer customer = null;
    @Override
    public void printMenu() {
        customer = new Customer();
        getAccountDetails();

        reprintAllDetails();
    }
    private void reprintAllDetails(){
        System.out.print("1. First Name*: " + customer.getFirstname());
        System.out.print("2. Last Name*: " + customer.getLastname());
        System.out.print("3. Middle Name: " + customer.getMiddlename());
        System.out.print("4. Address Line 1*: " + customer.getAddress_line_1());
        System.out.print("5. Address Line 2: " + customer.getAddress_line_2());
        System.out.print("6. City*: " + customer.getCity());
        System.out.print("7. Province*: " + customer.getProvince());
        System.out.print("8. Postal Code*: " + customer.getPostal_code());
        System.out.print("9. Email Address*: " + customer.getEmail_address());
        System.out.print("10. Contact Number*: " + customer.getContact());
        System.out.print("11. Passport Number*: " + customer.getPassport());
        System.out.print("12. SSN*: " + customer.getSsn_no());
        System.out.print("13. Save ");
        System.out.print("14. Back to Main Menu");
        System.out.println("Please enter number between 1-14 to perform appropriate action");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    private void getAccountDetails(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("First Name*: ");
        customer.setFirstname(scanner.nextLine());
        System.out.print("Last Name*: ");
        customer.setLastname(scanner.nextLine());
        System.out.print("Middle Name: ");
        customer.setMiddlename(scanner.nextLine());
        System.out.print("Address Line 1*: ");
        customer.setAddress_line_1(scanner.nextLine());
        System.out.print("Address Line 2: ");
        customer.setAddress_line_2(scanner.nextLine());
        System.out.print("City*: ");
        customer.setCity(scanner.nextLine());
        System.out.print("State/ Province*: ");
        customer.setProvince(scanner.nextLine());
        System.out.print("Postal Code*: ");
        customer.setPostal_code(scanner.nextLine());
        System.out.print("Email Address*: ");
        customer.setEmail_address(scanner.nextLine());
        System.out.print("Contact Number*: ");
        customer.setContact(scanner.nextLine());
        System.out.print("Passport Number*: ");
        customer.setPassport(scanner.nextLine());
        System.out.print("SSN*: ");
        customer.setSsn_no(scanner.nextLine());

    }
}
