package BusinessLogicLayer.BankAction;

public class OpenNewAccountStateContext {
    private FormState formState;

    public void setOpenNewAccountState(FormState formState) {
        this.formState = formState;
    }

    public void executeStateTask() {
        formState.performStateTask();
    }
}
