package PresentationLayer.MenuPages;

import BusinessLogicLayer.ActionFactory;
import BusinessLogicLayer.BankAction.EnrollNewEmployee;
import BusinessLogicLayer.BankAction.ExistingBankAccount;
import BusinessLogicLayer.BankAction.WorkList;
import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.CommonAction.SignOut;
import BusinessLogicLayer.IActionFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankManagerCommand extends Command {
    private Map<String, Action> menu;
    private static final String pageName = "BankManager";

    public BankManagerCommand() {
        IActionFactory actionFactory = new ActionFactory();

        menu = new LinkedHashMap<>();
        menu.put("1", actionFactory.createOpenNewAccount());
        menu.put("2", actionFactory.createExistingBankAccount());
        menu.put("3", actionFactory.createWorkList());
        menu.put("4", actionFactory.createEnrollNewEmployee());
        menu.put("5", actionFactory.createSignOut());
    }

    @Override
    public void execute() {
        MenuPage menuPage = new MenuPage(menu, "BankManager");
        menuPage.printMenu();
    }
}
