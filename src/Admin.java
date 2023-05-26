package src;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Admin extends DataManagement {
    public Scanner scanner = new Scanner(System.in);
    private final String userName = "Admin";
    private final String password = "Admin";

    public void printAdminMenu() {
        System.out.println("::::::::::::::::::::::::::::::::::::::::\n" +
                "           Admin MENUE OPTIONS\n" +
                "::::::::::::::::::::::::::::::::::::::::\n" +
                " ......................................\n" +
                "    <1> Add\n" +                       //write data
                "    <2> Update\n" +                    //write data
                "    <3> Remove\n" +                    //write data
                "    <4> Flight schedules\n" +          //read data
                "    <0> Sign out");
    }


    //=======================================   update   =============================


    /**
     * Admin can update a Flight features by using flight id
     *
     * @param flights array of flights
     */
    public void update(Flights flights) {
        int i = flights.searchFlight();
        if (i == -1) {
            System.out.println("Wrong FlightId !!!");
            return;
        }
        if (flights.flight[i].getReserveCount() > 0) {
            System.out.println("The flight is booked, you cannot update it !!!");
            return;
        }

        String strtmp = new String();
        System.out.print(".........................................................................................................................\n");
        System.out.printf("|%-15s |%-15s |%-15s  |%-15s |%-15s |%-15s |%-15s |\n", flights.flight[i].getFlightId(), flights.flight[i].getOrigin(), flights.flight[i].getDestination(), flights.flight[i].getDate(), flights.flight[i].getTime(), flights.flight[i].getPrice(), flights.flight[i].getSeat());
        System.out.print(".........................................................................................................................\n");
        System.out.println("Set new FlightId :\n" + "   <*>skip");
        strtmp = scanner.next();
        if (!Objects.equals(strtmp, "*")) {
            flights.flight[i].setFlightId(strtmp, flights);
        }
        System.out.println("Set new Origin :\n" + "   <*>skip");
        strtmp = scanner.next();
        if (!Objects.equals(strtmp, "*")) {
            flights.flight[i].setOrigin(strtmp);
        }
        System.out.println("Set new Destination :\n" + "   <*>skip");
        strtmp = scanner.next();
        if (!Objects.equals(strtmp, "*")) {
            flights.flight[i].setDestination(strtmp);
        }
        System.out.println("Set new Date :\n" + "   <*>skip");
        strtmp = scanner.next();
        if (!Objects.equals(strtmp, "*")) {
            flights.flight[i].setDate(strtmp);
        }
        System.out.println("Set new Time :\n" + "   <*>skip");
        strtmp = scanner.next();
        if (!Objects.equals(strtmp, "*")) {
            flights.flight[i].setTime(strtmp);
        }
        System.out.println("Set new Price :\n" + "   <*>skip");
        strtmp = scanner.next();
        if (!Objects.equals(strtmp, "*")) {
            flights.flight[i].setPrice(strtmp);
        }
        System.out.println("Set new Seat :\n" + "   <*>skip");
        strtmp = scanner.next();
        if (!Objects.equals(strtmp, "*")) {
            flights.flight[i].setSeat(strtmp);
        }
        System.out.println("Flight updated >>");
        System.out.print(".........................................................................................................................\n");
        System.out.printf("|%-15s |%-15s |%-15s  |%-15s |%-15s |%-15s |%-15s |\n", flights.flight[i].getFlightId(), flights.flight[i].getOrigin(), flights.flight[i].getDestination(), flights.flight[i].getDate(), flights.flight[i].getTime(), flights.flight[i].getPrice(), flights.flight[i].getSeat());
        System.out.print(".........................................................................................................................\n");
    }

    private void update() {
    }
    //=======================================   admin menu   =============================


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
                    update(flights);
                    break;
                case 3:
                    remove(flights);
                    break;
                case 4:
                    flights.flightSchedule(flights);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Wrong command!!!");
                    break;

            }

        }
    }

    public void adminMenu() throws IOException {
        String choice;

        while (true) {
            printAdminMenu();
            choice = scanner.next();
            switch (choice) {
                case "1":
                    add();
                    break;
                case "2":
                    update();
                    break;
                case "3":
                    remove();
                    break;
                case "4":
//                    flights.flightSchedule(flights);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Wrong command!!!");
                    break;

            }

        }
    }




//=======================================   add   =============================

    /**
     * Admin add a new flight
     *
     * @param flights
     */
    public void add(Flights flights) {
        int i = flights.findNullFlight();
        if (i == -1) {
            System.out.println("Flight list is full !!");
            return;
        }
        flights.flight[i] = new Flight();
        System.out.println("Set FlightId : ");
        flights.flight[i].setFlightId(scanner.next(), flights);
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
    public void add() throws IOException {
        Flight flight = new Flight();
        System.out.println("Set FlightId : ");
        flight.setFlightId(scanner.next());
        System.out.println("Set Origin : ");
        flight.setOrigin(scanner.next());
        System.out.println("Set Destination : ");
        flight.setDestination(scanner.next());
        System.out.println("Set Date : ");
        flight.setDate(scanner.next());
        System.out.println("Set Time : ");
        flight.setTime(scanner.next());
        System.out.println("Set Price : ");
        flight.setPrice(scanner.next());
        System.out.println("Set Seat : ");
        flight.setSeat(scanner.next());
        writeFlight(flight);
    }
//=======================================   remove   =============================

    /**
     * Admin remove a flight
     * <p>if the flight reserved by passenger admin can not remove it<p/>
     *
     * @param flights
     */
    public void remove(Flights flights) {
        int i = flights.searchFlight();
        if (i == -1) {
            System.out.println("Wrong FlightId !!!");
            return;
        }
        if (flights.flight[i].getReserveCount() > 0) {
            System.out.println("The flight is booked, you cannot remove it !!!");
            return;
        }
        flights.flight[i] = null;
    }
    private void remove() {
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}

