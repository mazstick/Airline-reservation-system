package src;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Admin admin = new Admin();
    public static Passengers[] passengers = new Passengers[20];
    public static Flights flights = new Flights();

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            passengers[i] = new Passengers();
        }
        flights.flightLib(flights);

        int counter = 0;
        while (true) {
            printMainMenue();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    SignIn signIn = new SignIn(passengers, admin, flights);
                    break;
                case 2:
                    SignUp signUp = new SignUp();
                    passengers[counter] = new Passengers();
                    passengers[counter].getUserName();
                    passengers[counter].getPassword();
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

}
