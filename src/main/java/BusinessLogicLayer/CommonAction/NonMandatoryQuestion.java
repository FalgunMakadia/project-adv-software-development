package BusinessLogicLayer.CommonAction;

public class NonMandatoryQuestion extends FormQuestion{
    public NonMandatoryQuestion(String questionCode) {
        super(questionCode);
    }

    @Override
    public void getStringUserInput(String message) {
        userInput = userInterface.getUserInput(message);
    }

}
