package BusinessLogicLayer;

import BusinessLogicLayer.BankCentricAction.EnrollNewEmployeeAction;
import BusinessLogicLayer.BankCentricAction.ExistingBankAccountAction;
import BusinessLogicLayer.BankCentricAction.OpenNewAccountAction;
import BusinessLogicLayer.BankCentricAction.WorkListAction;
import BusinessLogicLayer.CommonAction.IAction;
import BusinessLogicLayer.CommonAction.ISignInAction;
import BusinessLogicLayer.CommonAction.SignInAction;
import BusinessLogicLayer.CommonAction.SignOutAction;
import BusinessLogicLayer.CustomerCentricAction.*;
import BusinessLogicLayer.TransactionAction.DepositAction;
import BusinessLogicLayer.TransactionAction.TransferAction;
import BusinessLogicLayer.TransactionAction.WithdrawAction;
import BusinessLogicLayer.User.CustomerProfile;
import BusinessLogicLayer.User.AbstractProfile;

public class ActionFactory implements IActionFactory {
    @Override
    public IAction createOpenNewAccount() {
        return new OpenNewAccountAction();
    }

    @Override
    public IAction createExistingBankAccount() {
        return new ExistingBankAccountAction();
    }

    @Override
    public IAction createWorkList() {
        return new WorkListAction();
    }

    @Override
    public IAction createSignOut() {
        return new SignOutAction();
    }

    @Override
    public IAction createEnrollNewEmployee() {
        return new EnrollNewEmployeeAction();
    }

    @Override
    public IAction createUpdatePersonalDetails() {
        return new UpdatePersonalDetailAction();
    }

    @Override
    public IAction createWithdraw() {
        return new WithdrawAction();
    }

    @Override
    public IAction createDeposit() {
        return new DepositAction();
    }

    @Override
    public IAction createTransfer() {
        return new TransferAction();
    }

    @Override
    public IAction createBankStatement() {
        return new BankStatementAction();
    }

    @Override
    public IAction createCheckBalance() {
        return new CheckBalanceAction();
    }

    @Override
    public IAction createUpdatePassword() {
        return new UpdatePasswordAction();
    }

    @Override
    public IAction createLoanEstimator() {
        return new LoanEstimatorAction();
    }

    @Override
    public IAction createCheckPreApprovedLoan() {
        return new CheckPreApprovedLoanAction();
    }

    @Override
    public ISignInAction createLogin() {
        return new SignInAction();
    }

    @Override
    public AbstractProfile createCustomer() {
        return new CustomerProfile();
    }
}
