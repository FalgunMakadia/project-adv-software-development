package BusinessLogicLayer.ProfileForm.ProfileFormFields;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.FormCommand;
import BusinessLogicLayer.User.AbstractProfile;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateOfBirthFieldCommand extends FormCommand {
    private final String COMMAND_LABEL = "Date Of Birth";

    public DateOfBirthFieldCommand(AbstractProfile profile) {
        super(profile);
    }

    public DateOfBirthFieldCommand(AbstractProfile profile, IUserInterfacePage userInterfacePage) {
        super(profile);
        this.userInterface = userInterfacePage;
    }

    @Override
    public void execute() {
        String userInput = "";
        do {
            userInput = userInterface.getMandatoryUserInput("Enter DOB(YYYY-MM-DD)*: ");

        }while(validateBirthDate(userInput));
        profile.setDateOfBirth(userInput);
    }


    @Override
    public String getFieldValue() {
        return profile.getDateOfBirth();
    }

    @Override
    public String getCommandLabel() {
        return COMMAND_LABEL;
    }

    public boolean validateBirthDate(String birthDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        try {
            format.parse(birthDate);
        } catch (ParseException e) {
            userInterface.displayMessage("You entered invalid date format, correct format is (yyyy-MM-dd)");
            return true;
        }
        return false;
    }
}
