package PresentationLayer.MenuRouting;

public class MenuRoutingFactory implements IMenuRoutingFactory {
    @Override
    public IMenuRoutingCommand createExistingBankAccountCommand() {
        return new ExistingBankAccountMenuRoutingCommand();
    }
}
