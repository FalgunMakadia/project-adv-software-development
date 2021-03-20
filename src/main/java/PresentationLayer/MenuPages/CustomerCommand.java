package PresentationLayer.MenuPages;

import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.CommonAction.SignOut;
import BusinessLogicLayer.CustomerAction.*;
import BusinessLogicLayer.TransactionAction.Deposit;
import BusinessLogicLayer.TransactionAction.Transfer;
import BusinessLogicLayer.TransactionAction.Withdraw;
import BusinessLogicLayer.User.Customer;

import java.util.LinkedHashMap;
import java.util.Map;

public class CustomerCommand extends Command{
    private Map<String, Action> menu;
    public CustomerCommand(){
        menu = new LinkedHashMap<>();
        menu.put("1", new UpdatePersonalDetails());
        menu.put("2", new Withdraw());
        menu.put("3", new Deposit());
        menu.put("4", new Transfer());
        menu.put("5", new BankStatement());
        menu.put("6", new CheckBalance());
        menu.put("7", new UpdatePassword());
        menu.put("8", new LoanEstimator());
        menu.put("9", new CheckPreApprovedLoan());
        menu.put("10", new SignOut());
    }
    @Override
    public void execute() {
        MenuPage menuPage = new MenuPage(menu, "Customer");
        menuPage.printMenu();
    }
}
