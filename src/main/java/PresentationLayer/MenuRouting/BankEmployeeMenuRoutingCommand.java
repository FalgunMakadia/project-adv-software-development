package PresentationLayer.MenuRouting;

import BusinessLogicLayer.ActionFactory;
import BusinessLogicLayer.CommonAction.IAbstractAction;
import BusinessLogicLayer.IActionFactory;
import PresentationLayer.Pages.IPage;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankEmployeeMenuRoutingCommand extends MenuRoutingCommand {
    private Map<String, IAbstractAction> menu;
    private static final String pageName = "BankEmployeeProfile";

    public BankEmployeeMenuRoutingCommand(){
        IActionFactory actionFactory = new ActionFactory();
        menu = new LinkedHashMap<>();
        menu.put("1", actionFactory.createOpenNewAccount());
        menu.put("2", actionFactory.createExistingBankAccount());
        menu.put("3", actionFactory.createWorkList());
        menu.put("4", actionFactory.createSignOut());

    }
    @Override
    public void execute() {
        IPage menuPage = new MenuPage(menu, pageName);
        menuPage.printPage();
    }
}
