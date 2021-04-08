package BusinessLogicLayer;

import BusinessLogicLayer.BankCentricAction.EnrollNewEmployeeAction;
import BusinessLogicLayer.BankCentricAction.ExistingBankAccountAction;
import BusinessLogicLayer.BankCentricAction.OpenNewAccountAction;
import BusinessLogicLayer.BankCentricAction.WorkListAction;
import BusinessLogicLayer.CommonAction.IAbstractAction;
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
    public IAbstractAction createOpenNewAccount() {
        return new OpenNewAccountAction();
    }

    @Override
    public IAbstractAction createExistingBankAccount() {
        return new ExistingBankAccountAction();
    }

    @Override
    public IAbstractAction createWorkList() {
        return new WorkListAction();
    }

    @Override
    public IAbstractAction createSignOut() {
        return new SignOutAction();
    }

    @Override
    public IAbstractAction createEnrollNewEmployee() {
        return new EnrollNewEmployeeAction();
    }

    @Override
    public IAbstractAction createUpdatePersonalDetails() {
        return new UpdatePersonalDetailAction();
    }

    @Override
    public IAbstractAction createWithdraw() {
        return new WithdrawAction();
    }

    @Override
    public IAbstractAction createDeposit() {
        return new DepositAction();
    }

    @Override
    public IAbstractAction createTransfer() {
        return new TransferAction();
    }

    @Override
    public IAbstractAction createBankStatement() {
        return new BankStatementAction();
    }

    @Override
    public IAbstractAction createCheckBalance() {
        return new CheckBalanceAction();
    }

    @Override
    public IAbstractAction createUpdatePassword() {
        return new UpdatePasswordAction();
    }

    @Override
    public IAbstractAction createLoanEstimator() {
        return new LoanEstimatorAction();
    }

    @Override
    public IAbstractAction createCheckPreApprovedLoan() {
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
