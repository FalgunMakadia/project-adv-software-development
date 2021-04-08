package BusinessLogicLayer;

import BusinessLogicLayer.BankCentricAction.*;
import BusinessLogicLayer.CommonAction.*;
import BusinessLogicLayer.CustomerCentricAction.*;
<<<<<<< HEAD
import BusinessLogicLayer.TransactionAction.ITransactionActionFactory;
import BusinessLogicLayer.TransactionAction.TransactionActionFactory;
=======
import BusinessLogicLayer.TransactionAction.*;
import BusinessLogicLayer.User.CustomerProfile;
>>>>>>> 8e146f89722cf88184001f41bf0d5a5c892f3e7f
import BusinessLogicLayer.User.AbstractProfile;
import BusinessLogicLayer.User.IUserFactory;
import BusinessLogicLayer.User.UserFactory;

public class ActionFactory implements IActionFactory {

    IBankCentricActionFactory bankCentricActionFactory;
    ICustomerCentricActionFactory customerCentricActionFactory;
    ICommonActionFactory commonActionFactory;
    ITransactionActionFactory transactionActionFactory;
    IUserFactory userFactory;

    public ActionFactory() {
        bankCentricActionFactory = new BankCentricActionFactory();
        customerCentricActionFactory = new CustomerCentricActionFactory();
        commonActionFactory = new CommonActionFactory();
        transactionActionFactory = new TransactionActionFactory();
        userFactory = new UserFactory();
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
        return transactionActionFactory.createWithdrawAction();
    }

    @Override
    public IAbstractAction createDeposit() {
        return transactionActionFactory.createDepositAction();
    }

    @Override
    public IAbstractAction createTransfer() {
        return transactionActionFactory.createTransferAction();
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
