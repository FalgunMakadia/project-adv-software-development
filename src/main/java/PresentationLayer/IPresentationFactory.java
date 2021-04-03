package PresentationLayer;

import BusinessLogicLayer.CustomerAction.FormCommands.FormCommand;
import BusinessLogicLayer.CustomerAction.FormCommands.IFormCommand;
import BusinessLogicLayer.User.ProfileAbstract;
import PresentationLayer.CommonPages.IBankStatementTable;
import PresentationLayer.CommonPages.IUserDetailPage;
import PresentationLayer.CommonPages.IUserInterface;
import PresentationLayer.MenuPages.Command;
import PresentationLayer.MenuPages.IUserForm;
import PresentationLayer.CommonPages.IWorklistTable;

import java.util.Map;

public interface IPresentationFactory {
    IUserInterface createUserInterface();

    Command createExistingBankAccountCommand();

    IUserForm createUserForm(Map<Integer,IFormCommand> formFields, ProfileAbstract profileAbstract);

    IUserForm createUserForm(Map<Integer,IFormCommand> formFields, ProfileAbstract profileAbstract, String currentPage);

    IUserForm createUserForm(Map<Integer,IFormCommand> formFields);

    IWorklistTable createWorklistTable();

    IBankStatementTable createBankStatementTable();

    IUserDetailPage createUserDetailPage();
}
