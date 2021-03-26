package BusinessLogicLayer.BankAction;

import BusinessLogicLayer.CommonAction.FormQuestion;
import BusinessLogicLayer.CommonAction.MandatoryIntegerQuestion;
import BusinessLogicLayer.CommonAction.MandatoryQuestion;
import BusinessLogicLayer.CommonAction.NonMandatoryQuestion;

import java.util.Iterator;
import java.util.Map;

public class OpenNewAccountFormEditState extends FormState {
    String menuLabel;

    public OpenNewAccountFormEditState() {
        super();
        populateQuestionMap();
    }

    public OpenNewAccountFormEditState(String menuLabel) {
        super();
        this.menuLabel = menuLabel;
        populateQuestionMap();

    }

    @Override
    public void performStateTask() {
        int questionNumber = 1;
        Iterator<Map.Entry<String, FormQuestion>> iterator = questionMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, FormQuestion> formQuestionEntry = iterator.next();
            formQuestionEntry.getValue().getStringUserInput(formQuestionEntry.getKey());
            questionNumber = questionNumber + 1;
        }
    }

    private void populateQuestionMap() {
        questionMap.put("First Name*: ", new MandatoryQuestion(""));
        questionMap.put("Last Name*: ", new MandatoryQuestion(""));
        questionMap.put("Middle Name: ", new NonMandatoryQuestion(""));
        questionMap.put("Address Line 1*: ", new MandatoryQuestion(""));
        questionMap.put("Address Line 2: ", new NonMandatoryQuestion(""));
        questionMap.put("City*: ", new MandatoryQuestion(""));
        questionMap.put("State/ Province*: ", new MandatoryQuestion(""));
        questionMap.put("Postal Code*: ", new MandatoryQuestion(""));
        questionMap.put("Contact Number*: ", new MandatoryIntegerQuestion(""));
        questionMap.put("Passport Number*: ", new MandatoryQuestion(""));
        questionMap.put("SSN*: ", new MandatoryQuestion(""));
    }

    @Override
    public String getMenuLabel() {
        return menuLabel;
    }

}
