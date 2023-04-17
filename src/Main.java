package src;

import java.util.Random;
import java.util.Scanner;

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
