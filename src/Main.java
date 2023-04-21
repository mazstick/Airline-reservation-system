package src;

import java.util.Scanner;

/**
 * Airline Reservation System
 *<p>This project aims to simulate the online reservation system of airline tickets in a console application (non-graphics).
 *  The airline reservations System contains airline schedules, passenger reservations, and ticket records.
 *  This system includes two types of users like passengers, and system administrator</p>
 *
 * @author Mohammad Ali Zahmatkesh
 * @since 1402-01-14
 */
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Method method = new Method();
    public static Admin admin = new Admin();
    public static Passengers[] passengers = new Passengers[20];
    public static Flights flights = new Flights();

    public static void main(String[] args) {
        method.buildArray(passengers , 20);
        flights.flightLib(flights);
        method.mainMenu(passengers ,admin, flights);
    }
}
