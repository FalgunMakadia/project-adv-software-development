package BusinessLogicLayer;

import BusinessLogicLayer.CommonAction.IAbstractAction;
import BusinessLogicLayer.CommonAction.ISignInAction;
import BusinessLogicLayer.User.AbstractProfile;

public interface IActionFactory {
    IAbstractAction createOpenNewAccount();
    IAbstractAction createExistingBankAccount();
    IAbstractAction createWorkList();
    IAbstractAction createSignOut();
    IAbstractAction createEnrollNewEmployee();
    IAbstractAction createUpdatePersonalDetails();
    IAbstractAction createWithdraw();
    IAbstractAction createDeposit();
    IAbstractAction createTransfer();
    IAbstractAction createBankStatement();
    IAbstractAction createCheckBalance();
    IAbstractAction createUpdatePassword();
    IAbstractAction createLoanEstimator();
    IAbstractAction createCheckPreApprovedLoan();
    ISignInAction createLogin();
}
