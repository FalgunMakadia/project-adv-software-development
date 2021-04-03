package PresentationLayer;


import BusinessLogicLayer.CustomerAction.FormCommands.IFormCommand;
import BusinessLogicLayer.User.ProfileAbstract;
import PresentationLayer.CommonPages.IBankStatementTable;
import PresentationLayer.CommonPages.IUserDetailPage;
import PresentationLayer.CommonPages.IUserInterface;

import PresentationLayer.MenuPages.ICommand;
import PresentationLayer.MenuPages.IUserForm;
import PresentationLayer.CommonPages.IWorklistTable;

import java.util.Map;

public interface IPresentationFactory {
    IUserInterface createUserInterface();

    ICommand createExistingBankAccountCommand();

    IUserForm createUserForm(Map<Integer,IFormCommand> formFields, ProfileAbstract profileAbstract);

    IUserForm createUserForm(Map<Integer,IFormCommand> formFields, ProfileAbstract profileAbstract, String currentPage);

    IUserForm createUserForm(Map<Integer,IFormCommand> formFields);

    IWorklistTable createWorklistTable();

    IBankStatementTable createBankStatementTable();

    IUserDetailPage createUserDetailPage();
}
