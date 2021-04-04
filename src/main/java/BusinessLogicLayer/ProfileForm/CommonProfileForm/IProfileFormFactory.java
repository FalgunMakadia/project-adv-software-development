package BusinessLogicLayer.ProfileForm.CommonProfileForm;

import BusinessLogicLayer.User.BankEmployeeProfile;
import BusinessLogicLayer.User.ProfileAbstract;

import java.util.Map;

public interface IProfileFormFactory {
    IFormCommand createBackToMainMenuProfileFormActionCommand(String menuLabel);

    IFormCommand createEditProfileFormActionCommand(String menuLabel, ProfileAbstract profile, Map<Integer, IFormCommand> formFieldMap);

    IFormCommand createSaveNewAccountProfileFormActionCommand(String menuLabel, ProfileAbstract newCustomerProfile);

    IFormCommand createSaveNewEmployeeProfileFormActionCommand(String menuLabel, BankEmployeeProfile bankEmployeeProfile);

    IFormCommand createSaveUpdatedPersonalDetailFormActionCommand(ProfileAbstract profile);

    IFormCommand createAddressLine1FieldCommand(ProfileAbstract profile);

    IFormCommand createAddressLine2FieldCommand(ProfileAbstract profile);

    IFormCommand createCityFieldCommand(ProfileAbstract profile);

    IFormCommand createContactFieldCommand(ProfileAbstract profile);

    IFormCommand createDateOfBirthFieldCommand(ProfileAbstract profile);

    IFormCommand createEmailFieldCommand(ProfileAbstract profile);

    IFormCommand createFirstNameFieldCommand(ProfileAbstract profile);

    IFormCommand createLastNameFieldCommand(ProfileAbstract profile);

    IFormCommand createMiddleNameFieldCommand(ProfileAbstract profile);

    IFormCommand createPassPortNumberFieldCommand(ProfileAbstract profile);

    IFormCommand createPostalCodeFieldCommand(ProfileAbstract profile);

    IFormCommand createProvinceFieldCommand(ProfileAbstract profile);

    IFormCommand createSsnNumberFieldCommand(ProfileAbstract profile);
}
