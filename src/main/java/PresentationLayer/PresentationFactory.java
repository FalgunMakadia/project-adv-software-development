package PresentationLayer;

import BusinessLogicLayer.CustomerAction.FormCommands.IFormCommand;
import BusinessLogicLayer.User.ProfileAbstract;
import PresentationLayer.CommonPages.*;
import PresentationLayer.MenuPages.*;

import java.util.Map;

public class PresentationFactory implements IPresentationFactory {
    @Override
    public IUserInterface createUserInterface() {
        return new UserInterface();
    }

    @Override
    public ICommand createExistingBankAccountCommand() {
        return new ExistingBankAccountCommand();
    }

    @Override
    public IUserForm createUserForm(Map<Integer, IFormCommand> formFields, ProfileAbstract profileAbstract) {
        return new UserForm(formFields, profileAbstract);
    }
    @Override
    public IUserForm createUserForm(Map<Integer,IFormCommand> formFields, ProfileAbstract profileAbstract, String currentPage) {
        return new UserForm(formFields, profileAbstract, currentPage);
    }

    @Override
    public IUserForm createUserForm(Map<Integer,IFormCommand> formFields) {
        return new UserForm(formFields);
    }

    @Override
    public IWorklistTable createWorklistTable() {
        return new WorklistTable();
    }

    @Override
    public IBankStatementTable createBankStatementTable() {
        return new BankStatementTable();
    }

    @Override
    public IUserDetailPage createUserDetailPage() {
        return new UserDetailPage();
    }
}
