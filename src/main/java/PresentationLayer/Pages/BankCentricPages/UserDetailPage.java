package PresentationLayer.Pages.BankCentricPages;

import BusinessLogicLayer.User.ProfileAbstract;
import PresentationLayer.Pages.Page;

public class UserDetailPage extends Page {
    ProfileAbstract profile;
    public UserDetailPage(ProfileAbstract profileAbstract){
        this.profile = profileAbstract;
    }
    @Override
    public void printPage() {
        System.out.println("First Name: " + profile.getFirstName());
        System.out.println("Middle Name: " + profile.getMiddleName());
        System.out.println("Last Name: " + profile.getLastName());
        System.out.println("AddressLine 1: " + profile.getAddressLine1());
        System.out.println("AddressLine 2" + profile.getAddressLine2());
        System.out.println("City: " + profile.getCity());
        System.out.println("Province: " + profile.getProvince());
        System.out.println("Contact: " + profile.getContact());
        System.out.println("Email: " + profile.getEmailAddress());
        System.out.println("Passport Number: " + profile.getPassport());
        System.out.println("SSN Number: " + profile.getSsnNo());
        System.out.println("Postal Code: " + profile.getPostalCode());
        System.out.println("Date of Birth: " + profile.getDateOfBirth());
    }
}
