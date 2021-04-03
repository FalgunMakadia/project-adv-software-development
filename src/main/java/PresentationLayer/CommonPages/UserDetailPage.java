package PresentationLayer.CommonPages;

import BusinessLogicLayer.User.ProfileAbstract;

public class UserDetailPage implements IUserDetailPage {
    @Override
    public void printUserDetails(ProfileAbstract profileAbstract) {
        System.out.println("First Name: " + profileAbstract.getFirstName());
        System.out.println("Middle Name: " + profileAbstract.getMiddleName());
        System.out.println("Last Name: " + profileAbstract.getLastName());
        System.out.println("AddressLine 1: " + profileAbstract.getAddressLine1());
        System.out.println("AddressLine 2" + profileAbstract.getAddressLine2());
        System.out.println("City: " + profileAbstract.getCity());
        System.out.println("Province: " + profileAbstract.getProvince());
        System.out.println("Contact: " + profileAbstract.getContact());
        System.out.println("Email: " + profileAbstract.getEmailAddress());
        System.out.println("Passport Number: " + profileAbstract.getPassport());
        System.out.println("SSN Number: " + profileAbstract.getSsnNo());
        System.out.println("Postal Code: " + profileAbstract.getPostalCode());
        System.out.println("Date of Birth: " + profileAbstract.getDateOfBirth());
    }
}
