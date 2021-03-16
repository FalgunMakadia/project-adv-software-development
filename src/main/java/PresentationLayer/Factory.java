package PresentationLayer;

import BusinessLogicLayer.CommonAction.Action;

public abstract class Factory {
    public abstract Action createNewOpenNewAccount();

    public abstract Action updatePersonalDetails();
}
