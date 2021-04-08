package BusinessLogicLayer.CommonAction;

public interface ICommonActionFactory {
    ISignInAction createSignInAction();

    IAction createSignOutAction();
}
