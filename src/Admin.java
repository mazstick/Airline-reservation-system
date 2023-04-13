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



    public void adminMenu(Flights flights) {
        int choice;

        while (true) {
            printAdminMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    add(flights);
                    break;
                case 2:
                    break;
                case 3:
                    remove(flights);
                    break;
                case 4:
                    flights.flightSchedules(flights);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Wrong command!!!");
                    break;

            }

        }
    }

    public void add(Flights flights) {
        int i = flights.findeNullFlight();
        flights.flight[i] = new Flight();
        System.out.println("Set FlightId : ");
        flights.flight[i].setFlightId(scanner.next() , flights);
        System.out.println("Set Origin : ");
        flights.flight[i].setOrigin(scanner.next());
        System.out.println("Set Destination : ");
        flights.flight[i].setDestination(scanner.next());
        System.out.println("Set Date : ");
        flights.flight[i].setDate(scanner.next());
        System.out.println("Set Time : ");
        flights.flight[i].setTime(scanner.next());
        System.out.println("Set Price : ");
        flights.flight[i].setPrice(scanner.next());
        System.out.println("Set Seat : ");
        flights.flight[i].setSeat(scanner.next());
    }
    public void remove(Flights flights){
        int i = flights.searchFlight();
        flights.flight[i]=null;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}

