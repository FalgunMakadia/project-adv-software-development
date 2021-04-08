package PresentationLayer.Pages.CommonPages;

import BusinessLogicLayer.ProfileForm.CommonProfileForm.IAbstractFormCommand;
import PresentationLayer.Pages.Page;

import java.util.Map;
import java.util.Scanner;

public class FormPage extends Page {
    private static final String COMMAND_TYPE = "ACTION";

    private Map<Integer, IAbstractFormCommand> formFields;
    String currentPage;

    public FormPage(Map<Integer, IAbstractFormCommand> formFields, String currentPage) {
        this.formFields = formFields;
        this.currentPage = currentPage;
    }

    @Override
    public void printPage() {
        System.out.println("Form");
        do {
            Scanner scanner = new Scanner(System.in);
            for (int fieldIndex = 1; fieldIndex <= formFields.size(); fieldIndex++) {
               IAbstractFormCommand command = formFields.get(fieldIndex);
                if (null == command.getFieldValue() || COMMAND_TYPE == command.getFieldValue()) {
                    System.out.println(fieldIndex + ". " + command.getCommandLabel());
                } else {
                    System.out.println(fieldIndex + ". " + command.getCommandLabel() + ": " + command.getFieldValue());
                }
            }
            System.out.println("Enter Number between 1 to " + formFields.size() + " to edit the Form Fields");
            System.out.println("Enter 14 to go back to main menu");
            int userInput = scanner.nextInt();
            if (validateIntegerInputFormat(userInput)) {
               IAbstractFormCommand command = formFields.get(userInput);
                command.execute();
            }
        } while (loggedInUserContext.checkCurrentPageStatus(currentPage));
    }

    private boolean validateIntegerInputFormat(int input) {
        boolean validity = false;
        int choiceNumber = 0;
        try {
            choiceNumber = input;

            if (choiceNumber < 1 && choiceNumber > formFields.size()) {
                throw new IllegalArgumentException("Invalid input.");
            }
            validity = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return validity;
    }
}
