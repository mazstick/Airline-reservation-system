package src;

import java.util.Scanner;

public class SearchTicket {
    private boolean[] searchList = new boolean[7];
    private String flightId;
    private String origin;
    private String destination;
    private String date;
    private String time;
    private int priceI;
    private int priceF;
    private int seat;
    Scanner scanner = new Scanner(System.in);

    /**
     * The user determines the ticket based on which feature or features to filter
     * @param tickets
     */
    public SearchTicket(Tickets tickets) {
        for (int i = 0; i < 7; i++) {
            searchList[i] = false;
        }
        String choice;

        while (true) {
            printSearchMenu();
            choice = scanner.next();
            switch (choice) {
                case "1":
                    System.out.println("Enter flightId :");
                    flightId = scanner.next();
                    searchList[0] = true;
                    break;
                case "2":
                    System.out.println("Enter origin :");
                    origin = scanner.next();
                    searchList[1] = true;
                    break;
                case "3":
                    System.out.println("Enter destination :");
                    destination = scanner.next();
                    searchList[2] = true;
                    break;
                case "4":
                    System.out.println("Enter date :");
                    System.out.print("Year  >> ");
                    date = scanner.next();
                    System.out.print("Month >> ");
                    date = date + "-" + scanner.next();
                    System.out.print("Day   >> ");
                    date = date + "-" + scanner.next();
                    searchList[3] = true;
                    break;
                case "5":
                    System.out.println("Enter time :");
                    System.out.println("Hour   >> ");
                    time = scanner.next();
                    System.out.println("Minute >> ");
                    time = time + ":" + scanner.next();
                    searchList[4] = true;
                    break;
                case "6":
                    System.out.println("Enter start price :");
                    priceI = Integer.parseInt(scanner.next());
                    System.out.println("Enter end price :");
                    priceF = Integer.parseInt(scanner.next());
                    searchList[5] = true;
                    break;
                case "7":
                    System.out.println("Enter seat (more) :");
                    seat = Integer.parseInt(scanner.next());
                    searchList[6] = true;
                    break;
                case "0":
                    findAndFilter(searchList, tickets);
                    for (int i = 0; i < 7; i++) {
                        searchList[i] = false;
                    }
                    break;
                case "E":
                case "e":
                    return;
                default:
                    System.out.println("Incorrect choice !!!!");
                    break;
            }
        }

    }

    /**
     * If all the features specified by the user are available in a ticket, the ticket should be printed using this method
     * @param searchList
     * @param tickets
     */
    public void findAndFilter(boolean[] searchList, Tickets tickets) {
        boolean[] sample = new boolean[7];
        for (int i = 0; i < 7; i++) {
            sample[i] = false;
        }
        System.out.print("..........................................................................................................................................\n");
        System.out.printf("|%-15s |%-15s |%-15s |%-15s  |%-15s |%-15s |%-15s |%-15s |%n", "TicketId", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "Seat");

        for (int i = 0; i < tickets.ticket.length; i++) {
            if (tickets.ticket[i] != null) {
                //Search flight id --------------------
                if (searchList[0]) {
                    if (flightId.equals(tickets.ticket[i].getTicketId())) {
                        sample[0] = true;
                    }
                }
                //Search origin
                if (searchList[1]) {
                    if (origin.equals(tickets.ticket[i].getOrigin())) {
                        sample[1] = true;
                    }
                }
                //Search destination
                if (searchList[2]) {
                    if (destination.equals(tickets.ticket[i].getDestination())) {
                        sample[2] = true;
                    }
                }
                //search date
                if (searchList[3]) {
                    if (date.equals(tickets.ticket[i].getDate())) {
                        sample[3] = true;
                    }
                }
                //search time
                if (searchList[4]) {
                    if (time.equals(tickets.ticket[i].getTime())) {
                        sample[4] = true;
                    }
                }
                //search price
                if (searchList[5]) {
                    if (Integer.parseInt(tickets.ticket[i].getPrice()) > priceI && Integer.parseInt(tickets.ticket[i].getPrice()) < priceF) {
                        sample[5] = true;
                    }
                }
                //search seat
                if (searchList[6]) {
                    if (Integer.parseInt(tickets.ticket[i].getSeat()) > seat) {
                        sample[6] = true;
                    }
                }
                int counter = 0;
                for (int j = 0; j < 7; j++) {
                    if (sample[j] == searchList[j]) {
                        counter++;
                    }
                }
                if (counter == 7) {
                    System.out.print("..........................................................................................................................................\n");
                    System.out.printf("|%-15s |%-15s |%-15s |%-15s  |%-15s |%-15s |%-15s |%-15s |%n", tickets.ticket[i].getTicketId(), tickets.ticket[i].getFlightId(), tickets.ticket[i].getOrigin(), tickets.ticket[i].getDestination(), tickets.ticket[i].getDate(), tickets.ticket[i].getTime(), tickets.ticket[i].getPrice(), tickets.ticket[i].getSeat());
                }
            }
            //sample = false
            for (int j = 0; j < 7; j++) {
                sample[j] = false;
            }
        }
        System.out.print("..........................................................................................................................................\n");
    }


    public void printSearchMenu() {
        System.out.println("::::::::::::::::::::::::::::::::::::::::\n" +
                "         SEARCH TICKETS MENU OPTIONS\n" +
                "::::::::::::::::::::::::::::::::::::::::\n" +
                " ......................................\n" +
                "                  SEARCH BY\n" +
                "    <1> Flight ID\n" +
                "    <2> Origin\n" +
                "    <3> Destination\n" +
                "    <4> Date\n" +
                "    <5> Time\n" +
                "    <6> Price\n" +
                "    <7> Seat\n" +
                "    <0> --Next step >>\n" +
                "    <E> Exit\n");
    }
}
