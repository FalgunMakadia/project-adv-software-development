package BusinessLogicLayer.BankAction.FormActionCommands;

import BusinessLogicLayer.CommonAction.FormQuestion;
import PresentationLayer.CommonPages.IUserInterface;
import PresentationLayer.IPresentationFactory;
import PresentationLayer.PresentationFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class FormActionCommand {
    protected Map<String, FormQuestion> questionMap;

    public FormActionCommand() {
        questionMap = new LinkedHashMap<>();
        IPresentationFactory presentationFactory = new PresentationFactory();
    }

    public abstract void execute();

    public abstract String getMenuLabel();
}
