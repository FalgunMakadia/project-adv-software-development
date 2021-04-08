package BusinessLogicLayer;

import BusinessLogicLayer.BankCentricAction.*;
import BusinessLogicLayer.CommonAction.*;
import BusinessLogicLayer.CustomerCentricAction.*;
import BusinessLogicLayer.TransactionAction.DepositAction;
import BusinessLogicLayer.TransactionAction.TransferAction;
import BusinessLogicLayer.TransactionAction.WithdrawAction;
import BusinessLogicLayer.User.CustomerProfile;
import BusinessLogicLayer.User.AbstractProfile;

public class ActionFactory implements IActionFactory {

    IBankCentricActionFactory bankCentricActionFactory;
    ICustomerCentricActionFactory customerCentricActionFactory;
    ICommonActionFactory commonActionFactory;

    public ActionFactory() {
        bankCentricActionFactory = new BankCentricActionFactory();
        customerCentricActionFactory = new CustomerCentricActionFactory();
        commonActionFactory = new CommonActionFactory();
    }

    @Override
    public IAction createOpenNewAccount() {
        return bankCentricActionFactory.createOpenNewAccountAction();
    }

    @Override
    public IAction createExistingBankAccount() {
        return bankCentricActionFactory.createExistingBankAccountAction();
    }

    @Override
    public IAction createWorkList() {
        return bankCentricActionFactory.createWorkListAction();
    }

    @Override
    public IAction createSignOut() {
        return commonActionFactory.createSignOutAction();
    }

    @Override
    public IAction createEnrollNewEmployee() {
        return bankCentricActionFactory.createEnrollNewEmployeeAction();
    }

    @Override
    public IAction createUpdatePersonalDetails() {
        return customerCentricActionFactory.createUpdatePersonalDetailAction();
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
        return customerCentricActionFactory.createBankStatementAction();
    }

    @Override
    public IAction createCheckBalance() {
        return customerCentricActionFactory.createCheckBalanceAction();
    }

    @Override
    public IAction createUpdatePassword() {
        return customerCentricActionFactory.createUpdatePasswordAction();
    }

    @Override
    public IAction createLoanEstimator() {
        return customerCentricActionFactory.createLoanEstimatorAction();
    }

    @Override
    public IAction createCheckPreApprovedLoan() {
        return customerCentricActionFactory.createCheckPreApprovedLoanAction();
    }

    @Override
    public ISignInAction createLogin() {
        return commonActionFactory.createSignInAction();
    }

    @Override
    public AbstractProfile createCustomer() {
        return new CustomerProfile();
    }
}
