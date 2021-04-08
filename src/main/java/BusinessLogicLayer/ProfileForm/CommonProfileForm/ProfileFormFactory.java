package BusinessLogicLayer.ProfileForm.CommonProfileForm;

import BusinessLogicLayer.ProfileForm.ProfileFormAction.*;
import BusinessLogicLayer.ProfileForm.ProfileFormFields.*;
import BusinessLogicLayer.User.AbstractProfile;

import java.util.Map;

public class ProfileFormFactory implements IProfileFormFactory {
    @Override
    public IAbstractFormCommand createBackToMainMenuProfileFormActionCommand() {
        return new BackToMainMenuProfileFormActionCommand();
    }

    @Override
    public IAbstractFormCommand createEditProfileFormActionCommand(AbstractProfile profile, Map<Integer, IAbstractFormCommand> formFieldMap) {
        return new EditProfileFormActionCommand(profile, formFieldMap);
    }

    @Override
    public IAbstractFormCommand createSaveNewAccountProfileFormActionCommand(AbstractProfile newCustomerProfile) {
        return new SaveNewAccountProfileFormActionCommand(newCustomerProfile);
    }

    @Override
    public IAbstractFormCommand createSaveNewEmployeeProfileFormActionCommand(AbstractProfile bankEmployeeProfile) {
        return new SaveNewEmployeeProfileFormActionCommand(bankEmployeeProfile);
    }

    @Override
    public IAbstractFormCommand createSaveUpdatedPersonalDetailFormActionCommand(AbstractProfile profile) {
        return new SaveUpdatedPersonalDetailFormActionCommand(profile);
    }

    @Override
    public IAbstractFormCommand createAddressLine1FieldCommand(AbstractProfile profile) {
        return new AddressLine1FieldCommand(profile);
    }

    @Override
    public IAbstractFormCommand createAddressLine2FieldCommand(AbstractProfile profile) {
        return new AddressLine2FieldCommand(profile);
    }

    @Override
    public IAbstractFormCommand createCityFieldCommand(AbstractProfile profile) {
        return new CityFieldCommand(profile);
    }

    @Override
    public IAbstractFormCommand createContactFieldCommand(AbstractProfile profile) {
        return new ContactFieldCommand(profile);
    }

    @Override
    public IAbstractFormCommand createDateOfBirthFieldCommand(AbstractProfile profile) {
        return new DateOfBirthFieldCommand(profile);
    }

    @Override
    public IAbstractFormCommand createEmailFieldCommand(AbstractProfile profile) {
        return new EmailFieldCommand(profile);
    }

    @Override
    public IAbstractFormCommand createFirstNameFieldCommand(AbstractProfile profile) {
        return new FirstNameFieldCommand(profile);
    }

    @Override
    public IAbstractFormCommand createLastNameFieldCommand(AbstractProfile profile) {
        return new LastNameFieldCommand(profile);
    }

    @Override
    public IAbstractFormCommand createMiddleNameFieldCommand(AbstractProfile profile) {
        return new MiddleNameFieldCommand(profile);
    }

    @Override
    public IAbstractFormCommand createPassPortNumberFieldCommand(AbstractProfile profile) {
        return new PassPortNumberFieldCommand(profile);
    }

    @Override
    public IAbstractFormCommand createPostalCodeFieldCommand(AbstractProfile profile) {
        return new PostalCodeFieldCommand(profile);
    }

    @Override
    public IAbstractFormCommand createProvinceFieldCommand(AbstractProfile profile) {
        return new ProvinceFieldCommand(profile);
    }

    @Override
    public IAbstractFormCommand createSsnNumberFieldCommand(AbstractProfile profile) {
        return new SsnNumberFieldCommand(profile) ;
    }
}
