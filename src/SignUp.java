package src;

import java.util.Scanner;

/**
 * Sign up user as passenger
 */
public class SignUp {
    public Scanner scanner = new Scanner(System.in);
    public SignUp(Passengers passenger) {
        System.out.println("Enter your user name :");
        passenger.setUserName(scanner.next());
        System.out.println("Enter your password  :");
        passenger.setPassword(scanner.next());
    }

}
