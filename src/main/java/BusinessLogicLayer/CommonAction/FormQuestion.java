package BusinessLogicLayer.CommonAction;


import PresentationLayer.CommonPages.IUserInterface;
import PresentationLayer.IPresentationFactory;
import PresentationLayer.PresentationFactory;

public abstract class FormQuestion {
    protected String questionCode = "";
    protected String userInput = "";
    protected IUserInterface userInterface;
    public FormQuestion(String questionCode) {
        this.questionCode = questionCode;
        IPresentationFactory presentationFactory = new PresentationFactory();
        this.userInterface = presentationFactory.createUserInterface();
    }

    public abstract void getStringUserInput(String message);

}
