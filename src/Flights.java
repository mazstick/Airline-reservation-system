package src;

import java.util.Scanner;

public class Flights {
    public Flight[] flight = new Flight[20];
    public Scanner scanner = new Scanner(System.in);

    public void flightLib(Flights flights) {
        flights.flight[0] = new Flight("YT-30", "yazd", "tehran", "1402-01-20", "13:15", "500000", "300");
        flights.flight[1] = new Flight("MG-43", "mashhad", "ghazvin", "1402-01-22", "12:30", "2000000", "123");
        flights.flight[2] = new Flight("SA-90", "sari", "ardabil", "1402-01-23", "2:45", "400000", "200");
        flights.flight[3] = new Flight("GB-37", "ghom", "bandarabbas", "1402-01-30", "14:35", "320000", "110");
        flights.flight[4] = new Flight("RT-78", "rasht", "tabriz", "1402-02-03", "14:15", "450000", "420");
    }

    public void flightSchedules(Flights flights) {
        System.out.print(".........................................................................................................................\n");
        System.out.printf("|%-15s |%-15s |%-15s  |%-15s |%-15s |%-15s |%-15s |\n", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "Seat");
        for (int i = 0; i < flights.flight.length; i++) {
            if (flights.flight[i] != null) {
                System.out.print(".........................................................................................................................\n");
                System.out.printf("|%-15s |%-15s |%-15s  |%-15s |%-15s |%-15s |%-15s |\n", flight[i].getFlightId(), flight[i].getOrigin(), flight[i].getDestination(), flight[i].getDate(), flight[i].getTime(), flight[i].getPrice(), flight[i].getSeat());

            }
        }
        System.out.print(".........................................................................................................................\n");
    }

    public int findNullFlight() {
        for (int i = 0; i < flight.length; i++) {
            if (flight[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public int searchFlight() {
        String strtmp = new String();
        System.out.println("Enter FlightId :");
        strtmp = scanner.next();
        for (int i = 0; flight[i] != null; i++) {
            if (strtmp.equals(flight[i].getFlightId())) {
                return i;
            }
        }
        return -1;
    }
}
