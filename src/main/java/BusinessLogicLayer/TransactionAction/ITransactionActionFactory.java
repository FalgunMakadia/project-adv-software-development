package BusinessLogicLayer.TransactionAction;

import BusinessLogicLayer.CommonAction.IAbstractAction;

public interface ITransactionActionFactory {
    IAbstractAction createDepositAction();

    IAbstractAction createTransferAction();

    IAbstractAction createWithdrawAction();

    TransactionModel createTransactionModel(String accountNumber, String transactionType, int amount, String date);
}
