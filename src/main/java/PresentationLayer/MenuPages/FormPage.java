package PresentationLayer.MenuPages;

import BusinessLogicLayer.CustomerAction.FormCommands.FormCommand;
import BusinessLogicLayer.CustomerAction.FormCommands.IFormCommand;

import java.util.Map;
import java.util.Scanner;

public class FormPage extends Page {
    private Map<Integer, IFormCommand> formFields;
    String currentPage;

    public FormPage(Map<Integer,IFormCommand> formFields, String currentPage) {
        this.formFields = formFields;
        this.currentPage = currentPage;
    }

    @Override
    public void printMenu() {
        System.out.println("Form");
        do {
            Scanner scanner = new Scanner(System.in);
            for (int fieldIndex = 1; fieldIndex <= formFields.size(); fieldIndex++) {
               IFormCommand command = formFields.get(fieldIndex);
                if (null == command.getFieldValue()) {
                    System.out.println(fieldIndex + ". " + command.getCommandLabel());
                } else {
                    System.out.println(fieldIndex + ". " + command.getCommandLabel() + ": " + command.getFieldValue());
                }
            }
            System.out.println("Enter Number between 1 to " + formFields.size() + " to edit the Form Fields");
            System.out.println("Enter 14 to go back to main menu");
            int userInput = scanner.nextInt();
            if (validateIntegerInputFormat(userInput)) {
               IFormCommand command = formFields.get(userInput);
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
