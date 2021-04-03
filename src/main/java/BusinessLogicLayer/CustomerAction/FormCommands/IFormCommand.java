package BusinessLogicLayer.CustomerAction.FormCommands;

public interface IFormCommand {
    void execute();

    String getFieldValue();

    String getCommandLabel();
}
