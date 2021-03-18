package PresentationLayer.MenuPages;

import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.CommonAction.SignOut;
import BusinessLogicLayer.CustomerAction.*;
import BusinessLogicLayer.TransactionAction.Deposit;
import BusinessLogicLayer.TransactionAction.Transfer;
import BusinessLogicLayer.TransactionAction.Withdraw;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExistingBankAccountCommand extends Command{
    private Map<String, Action> menu;
    public ExistingBankAccountCommand(){
        menu = new LinkedHashMap<>();
        menu.put("1", new Withdraw());
        menu.put("2", new Deposit());
        menu.put("3", new Transfer());
        menu.put("4", new SignOut());
    }
    @Override
    public void execute() {
        MenuPage menuPage = new MenuPage(menu);
        menuPage.printMenu();
    }
}
