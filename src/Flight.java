package src;

import java.io.IOException;
import java.util.Scanner;

public class Flight extends DataManagement {
    public Scanner scanner = new Scanner(System.in);
    private String flightId;
    private String origin;
    private String destination;
    private String date;
    private String time;
    private String price;
    private String seat;
    private int reserveCount;

    public int getReserveCount() {
        return reserveCount;
    }

    /**
     * Set how many passenger reserve this flight
     *
     * @param reserveCount
     */
    public void setReserveCount(int reserveCount) {
        this.reserveCount += reserveCount;
    }

    public Flight(String flightId, String origin, String destination, String date, String time, String price, String seat) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.price = price;
        this.seat = seat;
    }


    public Flight() {

    }


    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId, Flights flights) {
        for (int i = 0; flights.flight[i] != null; i++) {
            if (flightId.equals(flights.flight[i].getFlightId())) // Do not accept if the flight number is duplicated
            {
                System.out.println("This FlightId is already exist \n Enter new FlightId >>");
                setFlightId(scanner.next(), flights);
                return;
            }
        }
        this.flightId = flightId;
    }

    public void setFlightId(String flightId) throws IOException {
        flightData = open(flightDataPath);
        for (int i = 0; i < flightData.length() / (12 * FIXED_SIZE + 4); i++) {
            flightData.seek(i * (12 * FIXED_SIZE + 4));
            if (readString(flightData).equals(flightId)) {
                System.out.println("This FlightId is already exist \n Enter new FlightId >>");
                setFlightId(scanner.next());
                return;
            }
        }
        this.flightId = flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
