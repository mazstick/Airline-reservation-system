package src;

import java.util.Scanner;

public class SignIn {
    private String userName;
    private String password;
    Scanner scanner = new Scanner(System.in);

    public SignIn(Passengers[] passengers) {
        System.out.println("Enter your username :");
        this.userName = scanner.next();
        System.out.println("Enter your password :");
        this.password = scanner.next();
        for (int i = 0; i < 20; i++) {
            if (passengers[i].getUserName().equals(this.userName)) {
                if (passengers[i].getPassword().equals(this.password)){
                    System.out.println("Login....");
                }
            }

        }
    }
}
