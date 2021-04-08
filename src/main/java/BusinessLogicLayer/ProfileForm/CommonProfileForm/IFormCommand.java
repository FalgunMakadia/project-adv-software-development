package BusinessLogicLayer.ProfileForm.CommonProfileForm;

public interface IFormCommand {
    void execute();

    String getFieldValue();

    String getCommandLabel();
}
