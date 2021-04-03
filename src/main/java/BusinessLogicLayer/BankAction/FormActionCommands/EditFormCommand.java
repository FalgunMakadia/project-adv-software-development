package BusinessLogicLayer.BankAction.FormActionCommands;

import BusinessLogicLayer.CustomerAction.FormCommands.FormCommand;
import BusinessLogicLayer.CustomerAction.FormCommands.IFormCommand;
import BusinessLogicLayer.User.ProfileAbstract;
import PresentationLayer.Pages.CommonPages.IUserInterfacePage;
import PresentationLayer.Pages.CommonPages.UserInterfacePage;
import PresentationLayer.IPresentationFactory;
import PresentationLayer.Pages.CommonPages.IUserFormPage;
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
        IUserFormPage userForm = commonPagesFactory.createUserForm(formFieldMap, profileAbstract);
        userForm.printForm();

        IUserInterfacePage userInterface = commonPagesFactory.createUserInterface();
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
