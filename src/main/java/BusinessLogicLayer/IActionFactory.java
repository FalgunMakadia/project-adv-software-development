package BusinessLogicLayer;

import BusinessLogicLayer.CommonAction.Action;
import BusinessLogicLayer.CommonAction.ILogin;
import BusinessLogicLayer.User.ProfileAbstract;

public interface IActionFactory {
    Action createOpenNewAccount();
    Action createExistingBankAccount();
    Action createWorkList();
    Action createSignOut();
    Action createEnrollNewEmployee();
    Action createUpdatePersonalDetails();
    Action createWithdraw();
    Action createDeposit();
    Action createTransfer();
    Action createBankStatement();
    Action createCheckBalance();
    Action createUpdatePassword();
    Action createLoanEstimator();
    Action createCheckPreApprovedLoan();
    ILogin createLogin();

    ProfileAbstract createCustomer();

}
