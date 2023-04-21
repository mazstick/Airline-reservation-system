package src;

import java.util.Scanner;

public class Method {
    public Scanner scanner = new Scanner(System.in);

    /**
     * mainMenu method menu of users for sign up and sign in
     *
     * @param passengers passengers array
     * @param admin
     * @param flights the class of flight array
     */
    public void mainMenu(Passengers[] passengers , Admin admin , Flights flights){
        int counter = 0;
        while (true) {
            printLoginMenu();
            String choice = scanner.next();
            switch (choice) {
                case "1": // sign in
                    SignIn signIn = new SignIn(passengers, admin, flights);
                    break;
                case "2": // sign up
                    passengers[counter] = new Passengers();
                    SignUp signUp = new SignUp(passengers[counter]);
                    counter++;
                    break;
                default:
                    System.out.println("Wrong choice!!");
                    break;
            }
        }
    }

    /**
     *
     * @param passengers
     * @param len
     */
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
