package BusinessLogicLayer.CommonAction;

public class CommonActionFactory implements ICommonActionFactory {
    @Override
    public ISignInAction createSignInAction() {
        return new SignInAction();
    }

    @Override
    public IAction createSignOutAction() {
        return new SignOutAction();
    }
}
