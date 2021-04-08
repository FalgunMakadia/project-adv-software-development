package BusinessLogicLayer.CommonAction;

public interface ICommonActionFactory {
    ISignInAction createSignInAction();

    IAbstractAction createSignOutAction();
}
