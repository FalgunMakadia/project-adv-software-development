package PresentationLayer.MenuRouting;

import BusinessLogicLayer.ActionFactory;
import BusinessLogicLayer.CommonAction.IAbstractAction;
import BusinessLogicLayer.IActionFactory;
import PresentationLayer.Pages.IAbstractPage;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankEmployeeMenuRoutingCommand extends MenuRoutingCommand {
    private static final String PAGE_NAME = "BankEmployee";

    private Map<String, IAbstractAction> menu;

    public BankEmployeeMenuRoutingCommand() {
        IActionFactory actionFactory = new ActionFactory();
        menu = new LinkedHashMap<>();
        menu.put("1", actionFactory.createOpenNewAccount());
        menu.put("2", actionFactory.createExistingBankAccount());
        menu.put("3", actionFactory.createWorkList());
        menu.put("4", actionFactory.createSignOut());
    }

    @Override
    public void execute() {
        IAbstractPage menuPage = new MenuPage(menu, PAGE_NAME);
        menuPage.printPage();
    }
}
