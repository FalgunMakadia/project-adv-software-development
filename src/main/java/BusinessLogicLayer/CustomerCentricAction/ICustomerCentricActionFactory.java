package BusinessLogicLayer.CustomerCentricAction;

import BusinessLogicLayer.CommonAction.IAction;

public interface ICustomerCentricActionFactory {
    IAction createBankStatementAction();

    IAction createCheckBalanceAction();

    IAction createCheckPreApprovedLoanAction();

    IAction createLoanEstimatorAction();

    IAction createUpdatePasswordAction();

    IAction createUpdatePersonalDetailAction();
}
