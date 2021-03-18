package PresentationLayer.CommonPages;

import java.util.Scanner;

public class UserInterface implements IUserInterface {
    Scanner scanner = null;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void insertEmptyLine() {
        System.out.println();
    }

    @Override
    public String getUserInput(String message) {
        System.out.print(message);
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    @Override
    public String getMandatoryUserInput(String message) {
        String input = "";
        while (input.trim().length() < 1) {
            System.out.print(message );
            input = scanner.nextLine();
            System.out.println();
        }
        return input;
    }

    @Override
    public String getMandatoryIntegerUserInput(String message) {
        String input = "";
        int choiceNumber = 0;
        while (input.length() < 1) {
            System.out.print(message);
            try {
                input = scanner.nextLine();
                choiceNumber = Integer.parseInt(input);
            }
            catch (Exception exception){
                input = "";
                System.out.println("Incorrect Input Format.");
            }
            System.out.println();
        }
        return input;
    }

    @Override
    public String getMandatoryIntegerUserInput(String message,int length) {
        String input = "";
        int choiceNumber = 0;
        while (input.length() < 1) {
            System.out.print(message);
            try {
                input = scanner.nextLine();
                choiceNumber = Integer.parseInt(input);
            }
            catch (Exception exception){
                input = "";
                System.out.println("Incorrect Input Format.");
            }
            System.out.println();
        }
        return input;
    }

    @Override
    public String getConfirmation(String message) {
        String input = "";
        while (input.length() < 1) {
            System.out.print(message + "(y/n): ");
            input = scanner.next();
            System.out.println();
        }
        return input;
    }
}
