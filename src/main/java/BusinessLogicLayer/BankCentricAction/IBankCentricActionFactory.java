package BusinessLogicLayer.BankCentricAction;

import BusinessLogicLayer.CommonAction.IAbstractAction;

public interface IBankCentricActionFactory {
    IAbstractAction createEnrollNewEmployeeAction();

    IAbstractAction createExistingBankAccountAction();

    IAbstractAction createOpenNewAccountAction();

    IAbstractAction createWorkListAction();
}
