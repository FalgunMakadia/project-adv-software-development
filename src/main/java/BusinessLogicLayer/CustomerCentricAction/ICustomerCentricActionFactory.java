package BusinessLogicLayer.CustomerCentricAction;

import BusinessLogicLayer.CommonAction.IAbstractAction;

public interface ICustomerCentricActionFactory {
    IAbstractAction createBankStatementAction();

    IAbstractAction createCheckBalanceAction();

    IAbstractAction createCheckPreApprovedLoanAction();

    IAbstractAction createLoanEstimatorAction();

    IAbstractAction createUpdatePasswordAction();

    IAbstractAction createUpdatePersonalDetailAction();
}
