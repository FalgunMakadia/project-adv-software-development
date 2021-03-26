package PresentationLayer.MenuPages;

import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.CustomerAction.FormCommands.FormCommand;

import java.util.Map;
import java.util.Scanner;

public class FormPage extends Page {
    private Map<Integer, FormCommand> formFields;

    public FormPage(Map<Integer, FormCommand> formFields, String parentPage) {
        this.formFields = formFields;
        loggedInUserContext.setParentPage(parentPage);
    }

    @Override
    public void printMenu() {
        System.out.println("Customer Form");
        boolean updateMode = true;
        while(updateMode) {
            Scanner scanner = new Scanner(System.in);
            for(int fieldIndex = 1; fieldIndex <= formFields.size(); fieldIndex++ ) {
                FormCommand command = formFields.get(fieldIndex);
                if(null == command.getFieldValue()) {
                    System.out.println(fieldIndex + ". " + command.getLabel());
                } else {
                    System.out.println(fieldIndex + ". " + command.getLabel() + ": " + command.getFieldValue());
                }
            }
            System.out.println("Enter Number between 1 to " + formFields.size() + " to edit the Form Fields");
            System.out.println("Enter 13 to save details and 14 to go back to main menu");
            int userInput = scanner.nextInt();
            if (validateIntegerInputFormat(userInput)) {
                if(userInput == 13) {
                    updateMode = false;
                } else if (userInput == 14) {
                    updateMode = false;
                } else {
                    FormCommand command = formFields.get(userInput);
                    command.execute();
                }
            }
        }
    }

    private boolean validateIntegerInputFormat(int input){
        boolean validity = false;
        int choiceNumber = 0;
        try {
            choiceNumber = input;

            if (choiceNumber < 1 && choiceNumber > formFields.size() + 2) {
                throw new IllegalArgumentException("Invalid input.");
            }
            validity = true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return validity;
    }
}
