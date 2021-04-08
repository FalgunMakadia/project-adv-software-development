package BusinessLogicLayer.ProfileForm.CommonProfileForm;

import BusinessLogicLayer.User.CustomerProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfileFormFactoryTest {
    IProfileFormFactory profileFormFactory;

    @BeforeEach
    void instantiate() {
        profileFormFactory = new ProfileFormFactory();
    }

    @Test
    void createBackToMainMenuProfileFormActionCommand() {
        IAbstractFormCommand formCommand = profileFormFactory.createBackToMainMenuProfileFormActionCommand();
        assertEquals("Back to Main Menu", formCommand.getCommandLabel());
    }

    @Test
    void createEditProfileFormActionCommand() {
        IAbstractFormCommand formCommand = profileFormFactory.createEditProfileFormActionCommand(null, null);
        assertEquals("Edit", formCommand.getCommandLabel());
    }

    @Test
    void createSaveNewAccountProfileFormActionCommand() {
        IAbstractFormCommand formCommand = profileFormFactory.createSaveNewAccountProfileFormActionCommand(null);
        assertEquals("Save", formCommand.getCommandLabel());
    }

    @Test
    void createSaveNewEmployeeProfileFormActionCommand() {
        IAbstractFormCommand formCommand = profileFormFactory.createSaveNewEmployeeProfileFormActionCommand(null);
        assertEquals("Save", formCommand.getCommandLabel());
    }

    @Test
    void createSaveUpdatedPersonalDetailFormActionCommand() {
        IAbstractFormCommand formCommand = profileFormFactory.createSaveUpdatedPersonalDetailFormActionCommand(new CustomerProfile());
        assertEquals("Save", formCommand.getCommandLabel());
    }

    @Test
    void createAddressLine1FieldCommand() {
        IAbstractFormCommand formCommand = profileFormFactory.createAddressLine1FieldCommand(null);
        assertEquals("Address Line 1", formCommand.getCommandLabel());
    }

    @Test
    void createAddressLine2FieldCommand() {
        IAbstractFormCommand formCommand = profileFormFactory.createAddressLine2FieldCommand(null);
        assertEquals("Address Line 2", formCommand.getCommandLabel());
    }

    @Test
    void createCityFieldCommand() {
        IAbstractFormCommand formCommand = profileFormFactory.createCityFieldCommand(null);
        assertEquals("City", formCommand.getCommandLabel());
    }

    @Test
    void createContactFieldCommand() {
        IAbstractFormCommand formCommand = profileFormFactory.createContactFieldCommand(null);
        assertEquals("Contact", formCommand.getCommandLabel());
    }

    @Test
    void createDateOfBirthFieldCommand() {
        IAbstractFormCommand formCommand = profileFormFactory.createDateOfBirthFieldCommand(null);
        assertEquals("Date Of Birth", formCommand.getCommandLabel());
    }

    @Test
    void createEmailFieldCommand() {
        IAbstractFormCommand formCommand = profileFormFactory.createEmailFieldCommand(null);
        assertEquals("Email", formCommand.getCommandLabel());
    }

    @Test
    void createFirstNameFieldCommand() {
        IAbstractFormCommand formCommand = profileFormFactory.createFirstNameFieldCommand(null);
        assertEquals("First Name", formCommand.getCommandLabel());
    }

    @Test
    void createLastNameFieldCommand() {
        IAbstractFormCommand formCommand = profileFormFactory.createLastNameFieldCommand(null);
        assertEquals("Last Name", formCommand.getCommandLabel());
    }

    @Test
    void createMiddleNameFieldCommand() {
        IAbstractFormCommand formCommand = profileFormFactory.createMiddleNameFieldCommand(null);
        assertEquals("Middle Name", formCommand.getCommandLabel());
    }

    @Test
    void createPassPortNumberFieldCommand() {
        IAbstractFormCommand formCommand = profileFormFactory.createPassPortNumberFieldCommand(null);
        assertEquals("Passport Number", formCommand.getCommandLabel());
    }

    @Test
    void createPostalCodeFieldCommand() {
        IAbstractFormCommand formCommand = profileFormFactory.createPostalCodeFieldCommand(null);
        assertEquals("Postal Code", formCommand.getCommandLabel());
    }

    @Test
    void createProvinceFieldCommand() {
        IAbstractFormCommand formCommand = profileFormFactory.createProvinceFieldCommand(null);
        assertEquals("Province", formCommand.getCommandLabel());
    }

    @Test
    void createSsnNumberFieldCommand() {
        IAbstractFormCommand formCommand = profileFormFactory.createSsnNumberFieldCommand(null);
        assertEquals("SSN Number", formCommand.getCommandLabel());
    }
}