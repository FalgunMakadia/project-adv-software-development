package BusinessLogicLayer.TransactionAction;

import BusinessLogicLayer.CommonAction.IAbstractAction;

public class TransactionActionFactory implements ITransactionActionFactory {
    @Override
    public IAbstractAction createDepositAction() {
        return new DepositAction();
    }

    @Override
    public IAbstractAction createTransferAction() {
        return new TransferAction();
    }

    @Override
    public IAbstractAction createWithdrawAction() {
        return new WithdrawAction();
    }

    @Override
    public TransactionModel createTransactionModel(String accountNumber, String transactionType, int amount, String date) {
        return new TransactionModel(accountNumber, transactionType, amount, date);
    }
}
