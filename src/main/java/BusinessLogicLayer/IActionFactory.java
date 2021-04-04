package BusinessLogicLayer;

import BusinessLogicLayer.CommonAction.IAction;
import BusinessLogicLayer.CommonAction.ISignInAction;
import BusinessLogicLayer.User.AbstractProfile;

public interface IActionFactory {
    IAction createOpenNewAccount();
    IAction createExistingBankAccount();
    IAction createWorkList();
    IAction createSignOut();
    IAction createEnrollNewEmployee();
    IAction createUpdatePersonalDetails();
    IAction createWithdraw();
    IAction createDeposit();
    IAction createTransfer();
    IAction createBankStatement();
    IAction createCheckBalance();
    IAction createUpdatePassword();
    IAction createLoanEstimator();
    IAction createCheckPreApprovedLoan();
    ISignInAction createLogin();

    AbstractProfile createCustomer();

}
