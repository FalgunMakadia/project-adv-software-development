package BusinessLogicLayer.BankCentricAction;

import BusinessLogicLayer.CommonAction.IAction;

public class BankCentricActionFactory implements IBankCentricActionFactory{
    @Override
    public IAction createEnrollNewEmployeeAction() {
        return new EnrollNewEmployeeAction();
    }

    @Override
    public IAction createExistingBankAccountAction() {
        return new ExistingBankAccountAction();
    }

    @Override
    public IAction createOpenNewAccountAction() {
        return new OpenNewAccountAction();
    }

    @Override
    public IAction createWorkListAction() {
        return new WorkListAction();
    }
}
