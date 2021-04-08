package BusinessLogicLayer.CustomerCentricAction;

import BusinessLogicLayer.CommonAction.IAbstractAction;

public class CustomerCentricActionFactory implements ICustomerCentricActionFactory{
    @Override
    public IAbstractAction createBankStatementAction() {
        return new BankStatementAction();
    }

    @Override
    public IAbstractAction createCheckBalanceAction() {
        return new CheckBalanceAction();
    }

    @Override
    public IAbstractAction createCheckPreApprovedLoanAction() {
        return new CheckPreApprovedLoanAction();
    }

    @Override
    public IAbstractAction createLoanEstimatorAction() {
        return new LoanEstimatorAction();
    }

    @Override
    public IAbstractAction createUpdatePasswordAction() {
        return new UpdatePasswordAction();
    }

    @Override
    public IAbstractAction createUpdatePersonalDetailAction() {
        return new UpdatePersonalDetailAction();
    }
}
