package BusinessLogicLayer.ProfileForm.CommonProfileForm;

public interface IAbstractFormCommand {
    void execute();

    String getFieldValue();

    String getCommandLabel();
}
