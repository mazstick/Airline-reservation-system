package src;

import java.util.Scanner;

public class Method {
    public Scanner scanner = new Scanner(System.in);
    public void mainMenu(Passengers[] passengers , Admin admin , Flights flights){
        int counter = 0;
        while (true) {
            printLoginMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    SignIn signIn = new SignIn(passengers, admin, flights);
                    break;
                case 2:
                    SignUp signUp = new SignUp();
                    passengers[counter] = new Passengers();
                    passengers[counter].setUserName(signUp.getUserName());
                    passengers[counter].setPassword(signUp.getPassword());
                    counter++;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }
    public void buildArray(Passengers[] passengers , int len){
        for (int i = 0; i < len; i++) {
            passengers[i] = new Passengers();
        }
    }
    public void printLoginMenu() {
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                "           WELCOME TO AIRELINE RESERVATION SYSTEM\n" +
                "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                "..........................MENU OPTIONS........................\n\n" +
                "    <1> Sign in\n" +
                "    <2> Sign up \n");
    }
}
