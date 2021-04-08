package PresentationLayer.MenuRouting;

import BusinessLogicLayer.CommonAction.IAbstractAction;
import PresentationLayer.Pages.AbstractPage;

import java.util.Map;
import java.util.Scanner;

public class MenuPage extends AbstractPage {

    private static final String INVALID_INPUT_ERROR_MESSAGE = "Invalid Input";

    private Map<String, IAbstractAction> menu;

    public MenuPage(Map<String, IAbstractAction> menu, String parentPage) {
        super();
        this.menu = menu;
        loggedInUserContext.setParentPage(parentPage);
    }

    public void printPage() {
        System.out.println("Welcome " + loggedInUserContext.getUserName() + "!");
        System.out.println();
        while (loggedInUserContext.getLoginStatus()) {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < menu.size(); i++) {
                int key = i + 1;
                IAbstractAction action = menu.get(String.valueOf(key));
                System.out.println(key + ". " + action.getActionTitle());
            }
            System.out.print("Enter any Number between 1-" + menu.size() + " to perform appropriate action:");
            String input = scanner.next();
            System.out.println("");
            if (validateIntegerInputFormat(input)) {
                IAbstractAction action = menu.get(input);
                action.performAction();
            }
        }
    }

    private boolean validateIntegerInputFormat(String input) {
        boolean validity = false;
        int choiceNumber = 0;
        try {
            choiceNumber = Integer.parseInt(input);

            if (choiceNumber < 1 && choiceNumber > menu.size()) {
                throw new IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE);
            }
            validity = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return validity;
    }
}