package PresentationLayer.MenuRouting;

import BusinessLogicLayer.ActionFactory;
import BusinessLogicLayer.CommonAction.IAbstractAction;
import BusinessLogicLayer.IActionFactory;
import PresentationLayer.Pages.IAbstractPage;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExistingBankAccountMenuRoutingCommand extends MenuRoutingCommand {

    private static final String PAGE_NAME = "ExistingBankAccount";

    private Map<String, IAbstractAction> menu;

    public ExistingBankAccountMenuRoutingCommand() {
        IActionFactory actionFactory = new ActionFactory();
        menu = new LinkedHashMap<>();
        menu.put("1", actionFactory.createWithdraw());
        menu.put("2", actionFactory.createDeposit());
        menu.put("3", actionFactory.createTransfer());
        menu.put("4", actionFactory.createSignOut());
    }

    @Override
    public void execute() {
        IAbstractPage menuPage = new MenuPage(menu, PAGE_NAME);
        menuPage.printPage();
    }
}
