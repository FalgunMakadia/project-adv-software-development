package PresentationLayer.CustomerActionPages;

import BusinessLogicLayer.CommonAction.Action;
import PresentationLayer.ActionFactory;
import PresentationLayer.Factory;
import PresentationLayer.Page;

public class UpdatePersonalDetailsPage extends Page {
    public void printMenu() {
        Factory factory = new ActionFactory();
        Action action = factory.updatePersonalDetails();
        action.performAction();
    }
}
