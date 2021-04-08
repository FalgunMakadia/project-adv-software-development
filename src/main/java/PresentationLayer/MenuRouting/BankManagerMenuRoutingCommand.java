package PresentationLayer.MenuRouting;

import BusinessLogicLayer.ActionFactory;
import BusinessLogicLayer.CommonAction.IAction;
import BusinessLogicLayer.IActionFactory;
import PresentationLayer.Pages.IPage;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankManagerMenuRoutingCommand extends MenuRoutingCommand {
    private Map<String, IAction> menu;
    private static final String pageName = "BankManager";

    public BankManagerMenuRoutingCommand() {
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
        IPage menuPage = new MenuPage(menu, "BankManager");
        menuPage.printPage();
    }
}