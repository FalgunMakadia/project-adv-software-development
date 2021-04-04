package BusinessLogicLayer.ProfileForm.CommonProfileForm;

import BusinessLogicLayer.User.BankEmployeeProfile;
import BusinessLogicLayer.User.AbstractProfile;

import java.util.Map;

public interface IProfileFormFactory {
    IFormCommand createBackToMainMenuProfileFormActionCommand(String menuLabel);

    IFormCommand createEditProfileFormActionCommand(String menuLabel, AbstractProfile profile, Map<Integer, IFormCommand> formFieldMap);

    IFormCommand createSaveNewAccountProfileFormActionCommand(String menuLabel, AbstractProfile newCustomerProfile);

    IFormCommand createSaveNewEmployeeProfileFormActionCommand(String menuLabel, BankEmployeeProfile bankEmployeeProfile);

    IFormCommand createSaveUpdatedPersonalDetailFormActionCommand(AbstractProfile profile);

    IFormCommand createAddressLine1FieldCommand(AbstractProfile profile);

    IFormCommand createAddressLine2FieldCommand(AbstractProfile profile);

    IFormCommand createCityFieldCommand(AbstractProfile profile);

    IFormCommand createContactFieldCommand(AbstractProfile profile);

    IFormCommand createDateOfBirthFieldCommand(AbstractProfile profile);

    IFormCommand createEmailFieldCommand(AbstractProfile profile);

    IFormCommand createFirstNameFieldCommand(AbstractProfile profile);

    IFormCommand createLastNameFieldCommand(AbstractProfile profile);

    IFormCommand createMiddleNameFieldCommand(AbstractProfile profile);

    IFormCommand createPassPortNumberFieldCommand(AbstractProfile profile);

    IFormCommand createPostalCodeFieldCommand(AbstractProfile profile);

    IFormCommand createProvinceFieldCommand(AbstractProfile profile);

    IFormCommand createSsnNumberFieldCommand(AbstractProfile profile);
}
