package BusinessLogicLayer.CommonAction;

import BusinessLogicLayer.User.ILoggedInUserContext;
import BusinessLogicLayer.User.LoggedInUserContext;
import PresentationLayer.IPresentationFactory;
import PresentationLayer.CommonPages.IUserInterface;
import PresentationLayer.PresentationFactory;

import java.math.BigInteger;

public abstract class Action {
    protected IUserInterface userInterface = null;
    protected ILoggedInUserContext loggedInUserContext;
    protected IPresentationFactory presentationFactory;
    public Action() {
        presentationFactory = new PresentationFactory();
        userInterface = presentationFactory.createUserInterface();
        loggedInUserContext = LoggedInUserContext.instance();
    }

    protected int convertStringToInteger(String input) {
        int choiceNumber = 0;
        try {
            choiceNumber = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input.");
        }
        return choiceNumber;
    }

    protected double convertStringToDouble(String input) {
        double choiceNumber = 0;
        try {
            choiceNumber = Double.parseDouble(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input.");
        }
        return choiceNumber;
    }

    protected long convertStringToLong(String input) {
        long choiceNumber = 0;
        try {
            choiceNumber = Long.parseLong(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input.");
        }
        return choiceNumber;
    }

    protected boolean validateIntegerInputFormat(String input) {
        boolean validity = true;
        int choiceNumber = 0;
        try {
            choiceNumber = Integer.parseInt(input);

        } catch (Exception exception) {
            validity = false;
            throw new IllegalArgumentException("Invalid input.");
        }
        return validity;
    }

    protected boolean validateLongInputFormat(String input) {
        boolean validity = true;
        long choiceNumber = 0;
        try {
            choiceNumber = Long.parseLong(input);

        } catch (Exception exception) {
            validity = false;
            throw new IllegalArgumentException("Invalid input.");
        }
        return validity;
    }


    public abstract void performAction();

    public abstract String getMenuLabel();
}
