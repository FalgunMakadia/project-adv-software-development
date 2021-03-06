package PresentationLayer.Pages.CommonPages;

import java.util.Scanner;

public class UserInterfacePage implements IUserInterfacePage {
    Scanner scanner = null;

    public UserInterfacePage() {
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
            System.out.print(message);
            input = scanner.nextLine();
            System.out.println();
        }
        return input;
    }

    @Override
    public String getMandatoryIntegerUserInput(String message) {
        String input = "";
        while (input.length() < 1) {
            System.out.print(message);
            try {
                input = scanner.nextLine();
                Integer.parseInt(input);
            } catch (Exception exception) {
                input = "";
                System.out.println("Incorrect Input Format.");
            }
            System.out.println();
        }
        return input;
    }

    @Override
    public String getMandatoryLongUserInputWithMinimumRange(String message, long minimumRange) {
        String input = "";
        do {
            System.out.print(message + "("+minimumRange+" digits)");
            try {
                input = scanner.nextLine();
                Long.parseLong(input);
            } catch (Exception exception) {
                input = "";
                System.out.println("Incorrect Input Format.");
            }
            System.out.println();
        } while (input.length() < minimumRange);
        return input;
    }

    @Override
    public String getMandatoryLongUserInputWithMinimumValue(String message, long minimumValue) {
        String input = "";
        long userNumber = 0;
        do {
            System.out.print(message + "( minimum "+minimumValue+"):");
            try {
                input = scanner.nextLine();
                userNumber = Long.parseLong(input);
            } catch (Exception exception) {
                input = "";
                System.out.println("Incorrect Input Format.");
            }
            System.out.println();
        } while (userNumber < minimumValue);
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

    @Override
    public String getUserInputInMultipleOfTen(String message) {
        String input = "";
        int amount = 0;
        while (input.length() < 1) {
            System.out.print(message);
            try {
                input = scanner.nextLine();
                amount = Integer.parseInt(input);
                if (amount % 10 != 0) {
                    throw new Exception();
                }
            }
            catch (Exception exception){
                input = "";
                System.out.println("Amount should be only in multiple of 10.");
            }
            System.out.println();
        }
        return input;
    }
}
