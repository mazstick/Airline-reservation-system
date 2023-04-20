package src;

import java.util.Scanner;

public class Flights {
    public Flight[] flight = new Flight[60];
    public Scanner scanner = new Scanner(System.in);

    public void flightLib(Flights flights) {
        flights.flight[0] = new Flight("YT-30", "Yazd", "Tehran", "1402-01-20", "13:15", "500000", "300");
        flights.flight[1] = new Flight("MG-43", "Mashhad", "Ghazvin", "1402-01-17", "12:30", "2000000", "123");
        flights.flight[2] = new Flight("SA-90", "Sari", "Ardabil", "1402-01-23", "2:45", "400000", "200");
        flights.flight[3] = new Flight("GB-37", "Ghom", "Bandarabbas", "1402-01-30", "14:35", "320000", "110");
        flights.flight[4] = new Flight("RT-78", "Rasht", "Tabriz", "1402-02-03", "14:15", "450000", "420");
        flights.flight[5] = new Flight("EK-83", "Esfehan", "Kerman", "1402-02-01", "22:10", "340000", "140");
        flights.flight[6] = new Flight("AS-22", "Ahvaz", "Semnan", "1402-01-31", "21:50", "700000", "330");
        flights.flight[7] = new Flight("SG-69", "Shiraz", "Gorgan", "1402-02-02", "18:05", "550000", "290");
        flights.flight[8] = new Flight("KK-97", "Kordestan", "Khorasan", "1402-02-10", "15:30", "680000", "250");
        flights.flight[9] = new Flight("BY-26", "Birjand", "Yasooj", "1402-02-04", "14:10", "360000", "300");

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
        String strtmp ;
        System.out.println("Enter FlightId :");
        strtmp = scanner.next();
        for (int i = 0; i < flight.length; i++) {
            if (flight[i]!= null) {
                if (strtmp.equals(flight[i].getFlightId())) {
                    return i;
                }
            }
        }
        return -1;
    }
}
