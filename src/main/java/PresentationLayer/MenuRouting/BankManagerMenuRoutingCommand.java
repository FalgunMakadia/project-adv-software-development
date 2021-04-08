package PresentationLayer.MenuRouting;

import BusinessLogicLayer.ActionFactory;
import BusinessLogicLayer.CommonAction.IAbstractAction;
import BusinessLogicLayer.IActionFactory;
import PresentationLayer.Pages.IAbstractPage;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankManagerMenuRoutingCommand extends MenuRoutingCommand {
    private static final String PAGE_NAME = "BankManager";

    private Map<String, IAbstractAction> menu;

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
        IAbstractPage menuPage = new MenuPage(menu, PAGE_NAME);
        menuPage.printPage();
    }
}
