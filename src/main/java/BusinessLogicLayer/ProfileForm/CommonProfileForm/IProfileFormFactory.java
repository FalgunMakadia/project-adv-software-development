package BusinessLogicLayer.ProfileForm.CommonProfileForm;

import BusinessLogicLayer.User.AbstractProfile;

import java.util.Map;

public interface IProfileFormFactory {
    IAbstractFormCommand createBackToMainMenuProfileFormActionCommand();

    IAbstractFormCommand createEditProfileFormActionCommand(AbstractProfile profile, Map<Integer, IAbstractFormCommand> formFieldMap);

    IAbstractFormCommand createSaveNewAccountProfileFormActionCommand(AbstractProfile newCustomerProfile);

    IAbstractFormCommand createSaveNewEmployeeProfileFormActionCommand(AbstractProfile bankEmployeeProfile);

    IAbstractFormCommand createSaveUpdatedPersonalDetailFormActionCommand(AbstractProfile profile);

    IAbstractFormCommand createAddressLine1FieldCommand(AbstractProfile profile);

    IAbstractFormCommand createAddressLine2FieldCommand(AbstractProfile profile);

    IAbstractFormCommand createCityFieldCommand(AbstractProfile profile);

    IAbstractFormCommand createContactFieldCommand(AbstractProfile profile);

    IAbstractFormCommand createDateOfBirthFieldCommand(AbstractProfile profile);

    IAbstractFormCommand createEmailFieldCommand(AbstractProfile profile);

    IAbstractFormCommand createFirstNameFieldCommand(AbstractProfile profile);

    IAbstractFormCommand createLastNameFieldCommand(AbstractProfile profile);

    IAbstractFormCommand createMiddleNameFieldCommand(AbstractProfile profile);

    IAbstractFormCommand createPassPortNumberFieldCommand(AbstractProfile profile);

    IAbstractFormCommand createPostalCodeFieldCommand(AbstractProfile profile);

    IAbstractFormCommand createProvinceFieldCommand(AbstractProfile profile);

    IAbstractFormCommand createSsnNumberFieldCommand(AbstractProfile profile);
}
