package BusinessLogicLayer.ProfileForm.CommonProfileForm;

import BusinessLogicLayer.User.CustomerProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfileFormFactoryTest {
    IProfileFormFactory profileFormFactory;

    @BeforeEach
    void instantiate(){
        profileFormFactory = new ProfileFormFactory();
    }
    @Test
    void createBackToMainMenuProfileFormActionCommand() {
        IFormCommand formCommand = profileFormFactory.createBackToMainMenuProfileFormActionCommand();
        assertEquals("Back to Main Menu",formCommand.getCommandLabel());
    }

    @Test
    void createEditProfileFormActionCommand() {
        IFormCommand formCommand = profileFormFactory.createEditProfileFormActionCommand(null,null);
        assertEquals("Edit",formCommand.getCommandLabel());
    }

    @Test
    void createSaveNewAccountProfileFormActionCommand() {
        IFormCommand formCommand = profileFormFactory.createSaveNewAccountProfileFormActionCommand(null);
        assertEquals("Save",formCommand.getCommandLabel());
    }

    @Test
    void createSaveNewEmployeeProfileFormActionCommand() {
        IFormCommand formCommand = profileFormFactory.createSaveNewEmployeeProfileFormActionCommand(null);
        assertEquals("Save",formCommand.getCommandLabel());
    }

    @Test
    void createSaveUpdatedPersonalDetailFormActionCommand() {
        IFormCommand formCommand = profileFormFactory.createSaveUpdatedPersonalDetailFormActionCommand(new CustomerProfile());
        assertEquals("Save",formCommand.getCommandLabel());
    }

    @Test
    void createAddressLine1FieldCommand() {
        IFormCommand formCommand = profileFormFactory.createAddressLine1FieldCommand(null);
        assertEquals("Address Line 1",formCommand.getCommandLabel());
    }

    @Test
    void createAddressLine2FieldCommand() {
        IFormCommand formCommand = profileFormFactory.createAddressLine2FieldCommand(null);
        assertEquals("Address Line 2",formCommand.getCommandLabel());
    }

    @Test
    void createCityFieldCommand() {
        IFormCommand formCommand = profileFormFactory.createCityFieldCommand(null);
        assertEquals("City",formCommand.getCommandLabel());
    }

    @Test
    void createContactFieldCommand() {
        IFormCommand formCommand = profileFormFactory.createContactFieldCommand(null);
        assertEquals("Contact",formCommand.getCommandLabel());
    }

    @Test
    void createDateOfBirthFieldCommand() {
        IFormCommand formCommand = profileFormFactory.createDateOfBirthFieldCommand(null);
        assertEquals("Date Of Birth",formCommand.getCommandLabel());
    }

    @Test
    void createEmailFieldCommand() {
        IFormCommand formCommand = profileFormFactory.createEmailFieldCommand(null);
        assertEquals("Email",formCommand.getCommandLabel());
    }

    @Test
    void createFirstNameFieldCommand() {
        IFormCommand formCommand = profileFormFactory.createFirstNameFieldCommand(null);
        assertEquals("First Name",formCommand.getCommandLabel());
    }

    @Test
    void createLastNameFieldCommand() {
        IFormCommand formCommand = profileFormFactory.createLastNameFieldCommand(null);
        assertEquals("Last Name",formCommand.getCommandLabel());
    }

    @Test
    void createMiddleNameFieldCommand() {
        IFormCommand formCommand = profileFormFactory.createMiddleNameFieldCommand(null);
        assertEquals("Middle Name",formCommand.getCommandLabel());
    }

    @Test
    void createPassPortNumberFieldCommand() {
        IFormCommand formCommand = profileFormFactory.createPassPortNumberFieldCommand(null);
        assertEquals("Passport Number",formCommand.getCommandLabel());
    }

    @Test
    void createPostalCodeFieldCommand() {
        IFormCommand formCommand = profileFormFactory.createPostalCodeFieldCommand(null);
        assertEquals("Postal Code",formCommand.getCommandLabel());
    }

    @Test
    void createProvinceFieldCommand() {
        IFormCommand formCommand = profileFormFactory.createProvinceFieldCommand(null);
        assertEquals("Province",formCommand.getCommandLabel());
    }

    @Test
    void createSsnNumberFieldCommand() {
        IFormCommand formCommand = profileFormFactory.createSsnNumberFieldCommand(null);
        assertEquals("SSN Number",formCommand.getCommandLabel());
    }
}