package BusinessLogicLayer;

import BusinessLogicLayer.BankAction.EnrollNewEmployee;
import BusinessLogicLayer.BankAction.ExistingBankAccount;
import BusinessLogicLayer.BankAction.OpenNewAccount;
import BusinessLogicLayer.BankAction.WorkList;
import BusinessLogicLayer.CommonAction.Action;
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
    public Action createOpenNewAccount() {
        return new OpenNewAccount();
    }

    @Override
    public Action createExistingBankAccount() {
        return new ExistingBankAccount();
    }

    @Override
    public Action createWorkList() {
        return new WorkList();
    }

    @Override
    public Action createSignOut() {
        return new SignOut();
    }

    @Override
    public Action createEnrollNewEmployee() {
        return new EnrollNewEmployee();
    }

    @Override
    public Action createUpdatePersonalDetails() {
        return new UpdatePersonalDetails();
    }

    @Override
    public Action createWithdraw() {
        return new Withdraw();
    }

    @Override
    public Action createDeposit() {
        return new Deposit();
    }

    @Override
    public Action createTransfer() {
        return new Transfer();
    }

    @Override
    public Action createBankStatement() {
        return new BankStatement();
    }

    @Override
    public Action createCheckBalance() {
        return new CheckBalance();
    }

    @Override
    public Action createUpdatePassword() {
        return new UpdatePassword();
    }

    @Override
    public Action createLoanEstimator() {
        return new LoanEstimator();
    }

    @Override
    public Action createCheckPreApprovedLoan() {
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
