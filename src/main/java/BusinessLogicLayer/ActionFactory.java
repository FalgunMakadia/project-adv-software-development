package BusinessLogicLayer;

import BusinessLogicLayer.BankAction.EnrollNewEmployee;
import BusinessLogicLayer.BankAction.ExistingBankAccount;
import BusinessLogicLayer.BankAction.OpenNewAccount;
import BusinessLogicLayer.BankAction.WorkList;
import BusinessLogicLayer.CommonAction.IAction;
import BusinessLogicLayer.CommonAction.ILogin;
import BusinessLogicLayer.CommonAction.Login;
import BusinessLogicLayer.CommonAction.SignOut;
import BusinessLogicLayer.CustomerAction.*;
import BusinessLogicLayer.TransactionAction.Deposit;
import BusinessLogicLayer.TransactionAction.Transfer;
import BusinessLogicLayer.TransactionAction.Withdraw;
import BusinessLogicLayer.User.CustomerProfile;
import BusinessLogicLayer.User.ProfileAbstract;

public class ActionFactory implements IActionFactory {
    @Override
    public IAction createOpenNewAccount() {
        return new OpenNewAccount();
    }

    @Override
    public IAction createExistingBankAccount() {
        return new ExistingBankAccount();
    }

    @Override
    public IAction createWorkList() {
        return new WorkList();
    }

    @Override
    public IAction createSignOut() {
        return new SignOut();
    }

    @Override
    public IAction createEnrollNewEmployee() {
        return new EnrollNewEmployee();
    }

    @Override
    public IAction createUpdatePersonalDetails() {
        return new UpdatePersonalDetails();
    }

    @Override
    public IAction createWithdraw() {
        return new Withdraw();
    }

    @Override
    public IAction createDeposit() {
        return new Deposit();
    }

    @Override
    public IAction createTransfer() {
        return new Transfer();
    }

    @Override
    public IAction createBankStatement() {
        return new BankStatement();
    }

    @Override
    public IAction createCheckBalance() {
        return new CheckBalance();
    }

    @Override
    public IAction createUpdatePassword() {
        return new UpdatePassword();
    }

    @Override
    public IAction createLoanEstimator() {
        return new LoanEstimator();
    }

    @Override
    public IAction createCheckPreApprovedLoan() {
        return new CheckPreApprovedLoan();
    }

    @Override
    public ILogin createLogin() {
        return new Login();
    }

    @Override
    public ProfileAbstract createCustomer() {
        return new CustomerProfile();
    }
}
