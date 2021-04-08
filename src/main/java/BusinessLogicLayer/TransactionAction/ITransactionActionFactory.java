package BusinessLogicLayer.TransactionAction;

import BusinessLogicLayer.CommonAction.IAction;

public interface ITransactionActionFactory {
    IAction createDepositAction();

    IAction createTransferAction();

    IAction createWithdrawAction();
}
