package PresentationLayer.CommonPages;

public interface IUserInterface {
    void displayMessage(String message);

    void insertEmptyLine();

    String getUserInput(String message);

    String getMandatoryUserInput(String message);

    String getMandatoryIntegerUserInput(String message);

    String getMandatoryLongUserInputWithMinimumRange(String message, long minimumRange);

    String getMandatoryIntegerUserInput(String message, int length);

    String getConfirmation(String message);

    void addDelay();
}
