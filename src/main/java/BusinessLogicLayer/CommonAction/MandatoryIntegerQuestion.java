package BusinessLogicLayer.CommonAction;

public class MandatoryIntegerQuestion extends FormQuestion{
    public MandatoryIntegerQuestion(String questionCode) {
        super(questionCode);
    }

    @Override
    public void getStringUserInput(String message) {
        userInput = userInterface.getMandatoryIntegerUserInput(message);
    }
}
