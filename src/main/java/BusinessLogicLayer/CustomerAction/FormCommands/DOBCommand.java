package BusinessLogicLayer.CustomerAction.FormCommands;

import BusinessLogicLayer.User.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DOBCommand extends FormCommand {
    private final String FIELD_LABEL = "Date Of Birth";

    public DOBCommand(User user) {
        super(user);
    }

    @Override
    public void execute() {
        String userInput = userInterface.getMandatoryUserInput("Enter DOB(YYYY-MM-DD)*: ");
        if(validateBirthDate(userInput)) {
            user.setDateOfBirth(userInput);
        }
    }

    @Override
    public String getFieldValue() {
        return user.getDateOfBirth();
    }

    @Override
    public String getMenuLabel() {
        return FIELD_LABEL;
    }

    public boolean validateBirthDate(String birthDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        try {
            format.parse(birthDate);
        } catch (ParseException e) {
            userInterface.displayMessage("You entered invalid date format, correct format is (yyyy-MM-dd)");
            return false;
        }
        return true;
    }
}
