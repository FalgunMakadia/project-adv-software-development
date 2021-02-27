package PL;

import java.net.SecureCacheResponse;
import java.util.Scanner;

public class LoginPage {
    private String username;
    private String password;
    private String authLevel;

    public String getUsername() {
        return username;
    }

    public String getAuthLevel() { return authLevel; }

    public String getPassword() {
        return password;
    }

    public void takeUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username:");
        this.username = scanner.nextLine();
        System.out.print("Password:");
        this.password = scanner.nextLine();
        System.out.print("Authorization Level:");
        this.authLevel = scanner.nextLine();
    }

    public void printUserValidityStatus(String isValid) {
        if(isValid == "C" ) {
            System.out.println("Valid User : Customer");
        } else if(isValid == "E") {
            System.out.println("Valid User : Employee");
        } else {
            System.out.println("Invalid User");
        }
    }
}
