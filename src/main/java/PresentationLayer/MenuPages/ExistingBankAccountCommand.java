package PresentationLayer.MenuPages;

import BusinessLogicLayer.ActionFactory;
import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.CommonAction.IAction;
import BusinessLogicLayer.CommonAction.SignOut;
import BusinessLogicLayer.CustomerAction.*;
import BusinessLogicLayer.IActionFactory;
import BusinessLogicLayer.TransactionAction.Deposit;
import BusinessLogicLayer.TransactionAction.Transfer;
import BusinessLogicLayer.TransactionAction.Withdraw;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExistingBankAccountCommand extends Command {
    private Map<String, IAction> menu;

    public ExistingBankAccountCommand() {
        IActionFactory actionFactory = new ActionFactory();

        menu = new LinkedHashMap<>();
        menu.put("1", actionFactory.createWithdraw());
        menu.put("2", actionFactory.createDeposit());
        menu.put("3", actionFactory.createTransfer());
        menu.put("4", actionFactory.createSignOut());
    }

    @Override
    public void execute() {
        MenuPage menuPage = new MenuPage(menu, "ExistingBankAccount");
        menuPage.printMenu();
    }
}
