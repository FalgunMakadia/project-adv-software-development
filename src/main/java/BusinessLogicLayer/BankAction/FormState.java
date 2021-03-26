package BusinessLogicLayer.BankAction;

import BusinessLogicLayer.CommonAction.FormQuestion;
import PresentationLayer.CommonPages.IUserInterface;
import PresentationLayer.IPresentationFactory;
import PresentationLayer.PresentationFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class FormState {
    protected Map<String, FormQuestion> questionMap;

    public FormState() {
        questionMap = new LinkedHashMap<>();
        IPresentationFactory presentationFactory = new PresentationFactory();
    }

    public abstract void performStateTask();

    public Map<String, FormQuestion> getQuestionMap() {
        return questionMap;
    }

    public abstract String getMenuLabel();
}
