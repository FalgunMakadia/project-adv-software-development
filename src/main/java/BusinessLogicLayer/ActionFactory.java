package BusinessLogicLayer;

import BusinessLogicLayer.BankCentricAction.*;
import BusinessLogicLayer.CommonAction.*;
import BusinessLogicLayer.CustomerCentricAction.*;
import BusinessLogicLayer.TransactionAction.*;
import BusinessLogicLayer.User.CustomerProfile;
import BusinessLogicLayer.User.AbstractProfile;

public class ActionFactory implements IActionFactory {

    IBankCentricActionFactory bankCentricActionFactory;
    ICustomerCentricActionFactory customerCentricActionFactory;
    ICommonActionFactory commonActionFactory;
    ITransactionActionFactory transactionActionFactory;

    public ActionFactory() {
        bankCentricActionFactory = new BankCentricActionFactory();
        customerCentricActionFactory = new CustomerCentricActionFactory();
        commonActionFactory = new CommonActionFactory();
        transactionActionFactory = new TransactionActionFactory();
    }

    @Override
    public IAbstractAction createOpenNewAccount() {
        return bankCentricActionFactory.createOpenNewAccountAction();
    }

    @Override
    public IAbstractAction createExistingBankAccount() {
        return bankCentricActionFactory.createExistingBankAccountAction();
    }

    @Override
    public IAbstractAction createWorkList() {
        return bankCentricActionFactory.createWorkListAction();
    }

    @Override
    public IAbstractAction createSignOut() {
        return commonActionFactory.createSignOutAction();
    }

    @Override
    public IAbstractAction createEnrollNewEmployee() {
        return bankCentricActionFactory.createEnrollNewEmployeeAction();
    }

    @Override
    public IAbstractAction createUpdatePersonalDetails() {
        return customerCentricActionFactory.createUpdatePersonalDetailAction();
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
        return customerCentricActionFactory.createBankStatementAction();
    }

    @Override
    public IAbstractAction createCheckBalance() {
        return customerCentricActionFactory.createCheckBalanceAction();
    }

    @Override
    public IAbstractAction createUpdatePassword() {
        return customerCentricActionFactory.createUpdatePasswordAction();
    }

    @Override
    public IAbstractAction createLoanEstimator() {
        return customerCentricActionFactory.createLoanEstimatorAction();
    }

    @Override
    public IAbstractAction createCheckPreApprovedLoan() {
        return customerCentricActionFactory.createCheckPreApprovedLoanAction();
    }

    @Override
    public ISignInAction createLogin() {
        return commonActionFactory.createSignInAction();
    }

}
