package src;

import java.io.IOException;
import java.util.Scanner;

/**
 * Sign up user as passenger
 */
public class SignUp extends DataManagement {
    public Scanner scanner = new Scanner(System.in);
    public SignUp(Passengers passenger) {
        System.out.println("Enter your user name :");
        passenger.setUserName(scanner.next());
        System.out.println("Enter your password  :");
        passenger.setPassword(scanner.next());
    }
    public SignUp() throws IOException {
        Passengers passenger = new Passengers();
        System.out.println("Enter your user name :");
        passenger.setUserName(scanner.next());
        System.out.println("Enter your password  :");
        passenger.setPassword(scanner.next());
        writePassenger(passenger);
    }

}
