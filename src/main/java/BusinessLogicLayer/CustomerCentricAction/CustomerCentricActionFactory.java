package BusinessLogicLayer.CustomerCentricAction;

import BusinessLogicLayer.CommonAction.IAction;

public class CustomerCentricActionFactory implements ICustomerCentricActionFactory{
    @Override
    public IAction createBankStatementAction() {
        return new BankStatementAction();
    }

    @Override
    public IAction createCheckBalanceAction() {
        return new CheckBalanceAction();
    }

    @Override
    public IAction createCheckPreApprovedLoanAction() {
        return new CheckPreApprovedLoanAction();
    }

    @Override
    public IAction createLoanEstimatorAction() {
        return new LoanEstimatorAction();
    }

    @Override
    public IAction createUpdatePasswordAction() {
        return new UpdatePasswordAction();
    }

    @Override
    public IAction createUpdatePersonalDetailAction() {
        return new UpdatePersonalDetailAction();
    }
}
