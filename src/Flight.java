package src;

public class Flight {
    private String flightId;
    private String origin;
    private String destination;
    private String date;
    private String time;
    private String price;

    public Flight(String flightId, String origin, String destination, String date, String time, String price, String seat) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.price = price;
        this.seat = seat;
    }

    private String seat;

    public Flight() {

    }

    public void flightSchedules(Flight[] flight){
        System.out.printf("|%-10s |%-10s |%-10s  |%-10s |%-10s |%-10s |%-10s |\n", "FlightId" , "Origin" , "Destination" , "Date", "Time" , "Price" , "Seat");
        for (int i = 0; flight[i] != null; i++) {
            System.out.println("...................................................................................\n");
            System.out.printf("|%-10s |%-10s |%-10s  |%-10s |%-10s |%-10s |%-10s |\n", flight[i].getFlightId() , flight[i].getOrigin() , flight[i].getDestination() , flight[i].getDate(), flight[i].getTime() , flight[i].getPrice() , flight[i].getSeat());

        }
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
