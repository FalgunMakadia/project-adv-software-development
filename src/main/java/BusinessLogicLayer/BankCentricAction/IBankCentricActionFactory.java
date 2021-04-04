package BusinessLogicLayer.BankCentricAction;

import BusinessLogicLayer.CommonAction.IAction;

public interface IBankCentricActionFactory {
    IAction createEnrollNewEmployeeAction();

    IAction createExistingBankAccountAction();

    IAction createOpenNewAccountAction();

    IAction createWorkListAction();
}
