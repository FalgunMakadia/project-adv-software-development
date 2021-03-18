package PresentationLayer;

public interface IUserInterface {
    void displayMessage(String message);
    void insertEmptyLine();
    String getUserInput(String message);
    String getMandatoryUserInput(String message);
    String getMandatoryIntegerUserInput(String message);
    String getConfirmation(String message);
}
