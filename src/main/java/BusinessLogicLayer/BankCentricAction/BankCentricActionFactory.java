package BusinessLogicLayer.BankCentricAction;

import BusinessLogicLayer.CommonAction.IAbstractAction;

public class BankCentricActionFactory implements IBankCentricActionFactory{
    @Override
    public IAbstractAction createEnrollNewEmployeeAction() {
        return new EnrollNewEmployeeAction();
    }

    @Override
    public IAbstractAction createExistingBankAccountAction() {
        return new ExistingBankAccountAction();
    }

    @Override
    public IAbstractAction createOpenNewAccountAction() {
        return new OpenNewAccountAction();
    }

    @Override
    public IAbstractAction createWorkListAction() {
        return new WorkListAction();
    }
}
