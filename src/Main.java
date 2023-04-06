package src;

import java.util.Scanner;

public class Main {
    public static Scanner scanner;

    public static void main(String[] args) {

        while (true) {
            printMainMenue();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(scanner.next().matches("[a-z]+[A-Z]+[0-9]+$"));
                    break;
                case 2:
                    new SignUp();
            }
        }
    }

    public static void printMainMenue() {
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n           WELCOME TO AIRELINE RESERVATION SYSTEM\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n..........................MENU OPTIONS........................\n\n    <1> Sign in\n    <2> Sign up \n");
    }

    static {
        scanner = new Scanner(System.in);
    }
}
