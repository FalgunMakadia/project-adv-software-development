package PL;

import java.net.SecureCacheResponse;
import java.util.Scanner;

public class LoginPage {
    private String username;
    private String password;

    public String getUsername() {
        return username;
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

    public void printUserValidityStatus(Boolean isValid) {
        if(isValid) {
            System.out.println("User is valid");
        } else {
            System.out.println("User is invalid (Hint: admin)");
        }
    }
}
