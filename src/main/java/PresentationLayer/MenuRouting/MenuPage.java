package PresentationLayer.MenuRouting;

import BusinessLogicLayer.CommonAction.IAction;
import PresentationLayer.Pages.Page;

import java.util.Map;
import java.util.Scanner;

public class MenuPage extends Page {
    private Map<String, IAction> menu;

    public MenuPage(Map<String, IAction> menu, String parentPage) {
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
                IAction action = menu.get(String.valueOf(key));
                System.out.println(key + ". " + action.getMenuLabel());
            }
            System.out.print("Enter any Number between 1-" + menu.size() + " to perform appropriate action:");
            String input = scanner.next();
            System.out.println("");
            if (validateIntegerInputFormat(input)) {
                IAction action = menu.get(input);
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
                throw new IllegalArgumentException("Invalid input.");
            }
            validity = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return validity;
    }
}
