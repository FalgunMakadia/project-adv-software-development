package BusinessLogicLayer;

import BusinessLogicLayer.CommonAction.IAction;
import BusinessLogicLayer.CommonAction.ILogin;
import BusinessLogicLayer.User.ProfileAbstract;

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
    ILogin createLogin();

    ProfileAbstract createCustomer();

}
