package src;

import java.util.Scanner;

public class Main {
    public static Scanner scanner;

    public static void main(String[] args) {
        Passengers[] passengers = new Passengers[20];
        Passengers passengers1 = new Passengers();
        int counter = 0;
        while (true) {
            printMainMenue();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    SignIn signIn = new SignIn(passengers);
                    break;
                case 2:
                    SignUp signUp = new SignUp();
                    passengers1.setUserName(signUp.getUserName());
                    passengers1.setPassword(signUp.getPassword());
                    passengers[counter] = passengers1;
                    counter++;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

    public static void printMainMenue() {
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                "           WELCOME TO AIRELINE RESERVATION SYSTEM\n" +
                "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                "..........................MENU OPTIONS........................\n\n" +
                "    <1> Sign in\n" +
                "    <2> Sign up \n");
    }

    static {
        scanner = new Scanner(System.in);
    }
}
