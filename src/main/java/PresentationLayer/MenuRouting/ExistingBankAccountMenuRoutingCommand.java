package PresentationLayer.MenuRouting;

import BusinessLogicLayer.ActionFactory;
import BusinessLogicLayer.CommonAction.IAction;
import BusinessLogicLayer.IActionFactory;
import PresentationLayer.Pages.IPage;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExistingBankAccountMenuRoutingCommand extends MenuRoutingCommand {
    private Map<String, IAction> menu;

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
        IPage menuPage = new MenuPage(menu, "ExistingBankAccount");
        menuPage.printPage();
    }
}
