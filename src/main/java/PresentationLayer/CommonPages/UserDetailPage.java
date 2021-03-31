package PresentationLayer.CommonPages;

import BusinessLogicLayer.User.User;

public class UserDetailPage implements IUserDetailPage {
    @Override
    public void printUserDetails(User user) {
        System.out.println("First Name: " + user.getFirstName());
        System.out.println("Middle Name: " + user.getMiddleName());
        System.out.println("Last Name: " + user.getLastName());
        System.out.println("AddressLine 1: " + user.getAddressLine1());
        System.out.println("AddressLine 2" + user.getAddressLine2());
        System.out.println("City: " + user.getCity());
        System.out.println("Province: " + user.getProvince());
        System.out.println("Contact: " + user.getContact());
        System.out.println("Email: " + user.getEmailAddress());
        System.out.println("Passport Number: " + user.getPassport());
        System.out.println("SSN Number: " + user.getSsnNo());
        System.out.println("Postal Code: " + user.getPostalCode());
        System.out.println("Date of Birth: " + user.getDateOfBirth());
    }
}
