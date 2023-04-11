package src;

import java.util.Scanner;

public class Admin {
    public Scanner scanner = new Scanner(System.in);
    private final String userName = "Admin";
    private final String password = "Admin";

    public void printAdminMenu() {
        System.out.println("::::::::::::::::::::::::::::::::::::::::\n" +
                "           Admin MENUE OPTIONS\n" +
                "::::::::::::::::::::::::::::::::::::::::\n" +
                " ......................................\n" +
                "    <1> Add\n" +
                "    <2> Update\n" +
                "    <3> Remove\n" +
                "    <4> Flight schedules\n" +
                "    <0> Sign out");
    }

    public void adminMenu() {
        int choice;
        Flights flights = new Flights();
        while (true) {
            printAdminMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    flights.flightSchedules();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Wrong command!!!");
                    break;

            }

        }
    }


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}

