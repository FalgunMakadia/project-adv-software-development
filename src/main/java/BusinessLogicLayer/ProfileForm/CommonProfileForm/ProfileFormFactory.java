package BusinessLogicLayer.ProfileForm.CommonProfileForm;

import BusinessLogicLayer.ProfileForm.ProfileFormAction.*;
import BusinessLogicLayer.ProfileForm.ProfileFormFields.*;
import BusinessLogicLayer.User.BankEmployeeProfile;
import BusinessLogicLayer.User.ProfileAbstract;

import java.util.Map;

public class ProfileFormFactory implements IProfileFormFactory{
    @Override
    public IFormCommand createBackToMainMenuProfileFormActionCommand(String menuLabel) {
        return new BackToMainMenuProfileFormActionCommand(menuLabel);
    }

    @Override
    public IFormCommand createEditProfileFormActionCommand(String menuLabel, ProfileAbstract profile, Map<Integer, IFormCommand> formFieldMap) {
        return new EditProfileFormActionCommand(menuLabel, profile, formFieldMap);
    }

    @Override
    public IFormCommand createSaveNewAccountProfileFormActionCommand(String menuLabel, ProfileAbstract newCustomerProfile) {
        return new SaveNewAccountProfileFormActionCommand(menuLabel, newCustomerProfile);
    }

    @Override
    public IFormCommand createSaveNewEmployeeProfileFormActionCommand(String menuLabel, BankEmployeeProfile bankEmployeeProfile) {
        return new SaveNewEmployeeProfileFormActionCommand(menuLabel, bankEmployeeProfile);
    }

    @Override
    public IFormCommand createSaveUpdatedPersonalDetailFormActionCommand(ProfileAbstract profile) {
        return new SaveUpdatedPersonalDetailFormActionCommand(profile);
    }

    @Override
    public IFormCommand createAddressLine1FieldCommand(ProfileAbstract profile) {
        return new AddressLine1FieldCommand(profile);
    }

    @Override
    public IFormCommand createAddressLine2FieldCommand(ProfileAbstract profile) {
        return new AddressLine2FieldCommand(profile);
    }

    @Override
    public IFormCommand createCityFieldCommand(ProfileAbstract profile) {
        return new CityFieldCommand(profile);
    }

    @Override
    public IFormCommand createContactFieldCommand(ProfileAbstract profile) {
        return new ContactFieldCommand(profile);
    }

    @Override
    public IFormCommand createDateOfBirthFieldCommand(ProfileAbstract profile) {
        return new DateOfBirthFieldCommand(profile);
    }

    @Override
    public IFormCommand createEmailFieldCommand(ProfileAbstract profile) {
        return new EmailFieldCommand(profile);
    }

    @Override
    public IFormCommand createFirstNameFieldCommand(ProfileAbstract profile) {
        return new FirstNameFieldCommand(profile);
    }

    @Override
    public IFormCommand createLastNameFieldCommand(ProfileAbstract profile) {
        return new LastNameFieldCommand(profile);
    }

    @Override
    public IFormCommand createMiddleNameFieldCommand(ProfileAbstract profile) {
        return new MiddleNameFieldCommand(profile);
    }

    @Override
    public IFormCommand createPassPortNumberFieldCommand(ProfileAbstract profile) {
        return new PassPortNumberFieldCommand(profile);
    }

    @Override
    public IFormCommand createPostalCodeFieldCommand(ProfileAbstract profile) {
        return new PostalCodeFieldCommand(profile);
    }

    @Override
    public IFormCommand createProvinceFieldCommand(ProfileAbstract profile) {
        return new ProvinceFieldCommand(profile);
    }

    @Override
    public IFormCommand createSsnNumberFieldCommand(ProfileAbstract profile) {
        return new SsnNumberFieldCommand(profile) ;
    }
}
