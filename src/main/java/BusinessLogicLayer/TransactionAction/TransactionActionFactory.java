package BusinessLogicLayer.TransactionAction;

import BusinessLogicLayer.CommonAction.IAction;

public class TransactionActionFactory implements ITransactionActionFactory {
    @Override
    public IAction createDepositAction() {
        return new DepositAction();
    }

    @Override
    public IAction createTransferAction() {
        return new TransferAction();
    }

    @Override
    public IAction createWithdrawAction() {
        return new WithdrawAction();
    }
}
