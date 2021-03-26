package PresentationLayer.MenuPages;

import BusinessLogicLayer.ActionFactory;
import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.IActionFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankEmployeeCommand extends Command{
    private Map<String, Action> menu;
    private static final String pageName = "BankEmployee";

    public BankEmployeeCommand(){
        IActionFactory actionFactory = new ActionFactory();
        menu = new LinkedHashMap<>();
        menu.put("1", actionFactory.createOpenNewAccount());
        menu.put("2", actionFactory.createExistingBankAccount());
        menu.put("3", actionFactory.createWorkList());
        menu.put("4", actionFactory.createSignOut());

    }
    @Override
    public void execute() {
        MenuPage menuPage = new MenuPage(menu, pageName);
        menuPage.printMenu();
    }
}
