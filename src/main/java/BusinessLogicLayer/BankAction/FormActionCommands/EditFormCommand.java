package BusinessLogicLayer.BankAction.FormActionCommands;

import BusinessLogicLayer.CustomerAction.FormCommands.FormCommand;
import BusinessLogicLayer.CustomerAction.FormCommands.IFormCommand;
import BusinessLogicLayer.User.ProfileAbstract;
import PresentationLayer.CommonPages.UserInterface;
import PresentationLayer.IPresentationFactory;
import PresentationLayer.MenuPages.IUserForm;
import PresentationLayer.PresentationFactory;

import java.util.Map;

public class EditFormCommand extends FormCommand {
    String menuLabel;
    ProfileAbstract profileAbstract;
    Map<Integer,IFormCommand> formFieldMap;
    public EditFormCommand(String menuLabel, ProfileAbstract profileAbstract, Map<Integer, IFormCommand> formFieldMap) {
        super();
        this.menuLabel = menuLabel;
        this.profileAbstract = profileAbstract;
        this.formFieldMap = formFieldMap;
    }

    @Override
    public void execute() {
        IPresentationFactory presentationFactory = new PresentationFactory();
        IUserForm userForm = presentationFactory.createUserForm(formFieldMap, profileAbstract);
        userForm.executeForm();
        UserInterface userInterface = new UserInterface();
        for (int fieldIndex = 1; fieldIndex <= formFieldMap.size(); fieldIndex++) {
           IFormCommand command = formFieldMap.get(fieldIndex);

            userInterface.displayMessage(command.getCommandLabel() + ": " + command.getFieldValue());

        }

    }

    @Override
    public String getFieldValue() {
        return null;
    }

    @Override
    public String getCommandLabel() {
        return menuLabel;
    }

}
