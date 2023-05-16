package src;

import java.util.Random;

public class Ticket {
    private String ticketId;
    private String flightId;
    private String origin;
    private String destination;
    private String date;
    private String time;
    private String price;
    private String seat;
    private int flightIndex;

    public int getFlightIndex() {
        return flightIndex;
    }

    public void setFlightIndex(int flightIndex) {
        this.flightIndex = flightIndex;
    }

    public Ticket(String flightId, String origin, String destination, String date, String time, String price, String seat) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.price = price;
        this.seat = seat;
    }

    public String getTicketId() {
        return ticketId;
    }

    /**
     * This function build a ticket id for reserved ticket
     * <p>ticket id contain : (flight id)+(random number)+(passenger index)+(flight index) <p/>
     * <p>
     * The ticket id is unique >> Each ticket has unique passenger index and unique flight index
     * </p>
     * @param passengerIndex index of this passenger in passenger array
     * @param flightIndex index of this flight in flight array
     */
    public void setTicketId(int passengerIndex, int flightIndex) {
        Random random = new Random();
        int y = random.nextInt(90) + 10;
        String tmp = flightId;
        tmp = tmp + y + "-" + Integer.toString(passengerIndex + 1) +"-"+ Integer.toString(flightIndex + 1);
        this.ticketId = tmp;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
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
