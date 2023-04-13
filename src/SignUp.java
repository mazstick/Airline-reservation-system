package src;

import java.util.Scanner;

public class SignUp {
    public Scanner scanner = new Scanner(System.in);
    public SignUp(Passengers passenger) {
//        this.scanner = new Scanner(System.in);
        System.out.println("Enter your user name :");
        passenger.setUserName(scanner.next());
        System.out.println("Enter your password  :");
        passenger.setPassword(scanner.next());
    }

}
