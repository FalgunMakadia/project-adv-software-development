package PresentationLayer.Pages.CommonPages;

public interface IUserInterfacePage {
    void displayMessage(String message);

    void insertEmptyLine();

    String getUserInput(String message);

    String getMandatoryUserInput(String message);

    String getMandatoryIntegerUserInput(String message);

    String getMandatoryLongUserInputWithMinimumRange(String message, long minimumRange);

    String getConfirmation(String message);

    String getUserInputInMultipleOfTen(String message);

    void addDelay();
}
