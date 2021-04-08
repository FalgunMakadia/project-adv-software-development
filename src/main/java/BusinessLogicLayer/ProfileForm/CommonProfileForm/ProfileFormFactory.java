package BusinessLogicLayer.ProfileForm.CommonProfileForm;

import BusinessLogicLayer.ProfileForm.ProfileFormAction.*;
import BusinessLogicLayer.ProfileForm.ProfileFormFields.*;
import BusinessLogicLayer.User.AbstractProfile;

import java.util.Map;

public class ProfileFormFactory implements IProfileFormFactory{
    @Override
    public IFormCommand createBackToMainMenuProfileFormActionCommand() {
        return new BackToMainMenuProfileFormActionCommand();
    }

    @Override
    public IFormCommand createEditProfileFormActionCommand(AbstractProfile profile, Map<Integer, IFormCommand> formFieldMap) {
        return new EditProfileFormActionCommand(profile, formFieldMap);
    }

    @Override
    public IFormCommand createSaveNewAccountProfileFormActionCommand(AbstractProfile newCustomerProfile) {
        return new SaveNewAccountProfileFormActionCommand(newCustomerProfile);
    }

    @Override
    public IFormCommand createSaveNewEmployeeProfileFormActionCommand(AbstractProfile bankEmployeeProfile) {
        return new SaveNewEmployeeProfileFormActionCommand(bankEmployeeProfile);
    }

    @Override
    public IFormCommand createSaveUpdatedPersonalDetailFormActionCommand(AbstractProfile profile) {
        return new SaveUpdatedPersonalDetailFormActionCommand(profile);
    }

    @Override
    public IFormCommand createAddressLine1FieldCommand(AbstractProfile profile) {
        return new AddressLine1FieldCommand(profile);
    }

    @Override
    public IFormCommand createAddressLine2FieldCommand(AbstractProfile profile) {
        return new AddressLine2FieldCommand(profile);
    }

    @Override
    public IFormCommand createCityFieldCommand(AbstractProfile profile) {
        return new CityFieldCommand(profile);
    }

    @Override
    public IFormCommand createContactFieldCommand(AbstractProfile profile) {
        return new ContactFieldCommand(profile);
    }

    @Override
    public IFormCommand createDateOfBirthFieldCommand(AbstractProfile profile) {
        return new DateOfBirthFieldCommand(profile);
    }

    @Override
    public IFormCommand createEmailFieldCommand(AbstractProfile profile) {
        return new EmailFieldCommand(profile);
    }

    @Override
    public IFormCommand createFirstNameFieldCommand(AbstractProfile profile) {
        return new FirstNameFieldCommand(profile);
    }

    @Override
    public IFormCommand createLastNameFieldCommand(AbstractProfile profile) {
        return new LastNameFieldCommand(profile);
    }

    @Override
    public IFormCommand createMiddleNameFieldCommand(AbstractProfile profile) {
        return new MiddleNameFieldCommand(profile);
    }

    @Override
    public IFormCommand createPassPortNumberFieldCommand(AbstractProfile profile) {
        return new PassPortNumberFieldCommand(profile);
    }

    @Override
    public IFormCommand createPostalCodeFieldCommand(AbstractProfile profile) {
        return new PostalCodeFieldCommand(profile);
    }

    @Override
    public IFormCommand createProvinceFieldCommand(AbstractProfile profile) {
        return new ProvinceFieldCommand(profile);
    }

    @Override
    public IFormCommand createSsnNumberFieldCommand(AbstractProfile profile) {
        return new SsnNumberFieldCommand(profile) ;
    }
}
