package PresentationLayer.MenuPages;

import BusinessLogicLayer.BankAction.ExistingBankAccount;
import BusinessLogicLayer.BankAction.OpenNewAccount;
import BusinessLogicLayer.BankAction.WorkList;
import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.CommonAction.SignOut;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankEmployeeCommand extends Command{
    private Map<String, Action> menu;

    public BankEmployeeCommand(){
        menu = new LinkedHashMap<>();
        menu.put("1", new OpenNewAccount());
        menu.put("2", new ExistingBankAccount());
        menu.put("3", new WorkList());
        menu.put("4", new SignOut());

    }
    @Override
    public void execute() {
        MenuPage menuPage = new MenuPage(menu);
        menuPage.printMenu();
    }
}
