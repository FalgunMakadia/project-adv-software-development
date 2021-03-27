package BusinessLogicLayer.CommonAction;

public class MandatoryQuestion extends FormQuestion{
    public MandatoryQuestion(String questionCode) {
        super(questionCode);
    }

    @Override
    public void getStringUserInput(String message) {
        userInput = userInterface.getMandatoryUserInput(message);
    }

}
