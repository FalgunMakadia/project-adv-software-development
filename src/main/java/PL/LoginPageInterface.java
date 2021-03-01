package PL;

import java.net.SecureCacheResponse;
import java.util.Scanner;

public class LoginPageInterface {
    private String username;
    private String password;
    private String authLevel;

    public String getUsername() {
        return username;
    }

    public String getAuthLevel() {
        return authLevel;
    }

    public String getPassword() {
        return password;
    }

    public void takeUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username:");
        this.username = scanner.nextLine();
        System.out.print("Password:");
        this.password = scanner.nextLine();
    }

    public void printUserValidityStatus(String isValid) {
        if (isValid == "C") {
            System.out.println("Valid User : Customer");
        }
        else if (isValid == "E") {
            System.out.println("Valid User : Bank Employee");
        }
        else if (isValid == "M") {
            System.out.println("Valid User : Bank Manager");
        }
        else {
            System.out.println("Invalid User");
        }
    }
}
