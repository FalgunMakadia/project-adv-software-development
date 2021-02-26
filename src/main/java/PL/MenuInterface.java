package PL;

import BLL.Login;

import java.util.Scanner;

public class MenuInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userName, password;

        System.out.println("Please enter your login credentials");
        System.out.println("User Name :");
        userName = sc.next();
        System.out.println("User Name :");
        password = sc.next();

        Login login = new Login(userName, password);

    }
}
