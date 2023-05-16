package src;

import java.util.Scanner;

public class Passengers extends Data{
    public Scanner scanner = new Scanner(System.in);

    public Passengers() {
        this.userName = "";
        this.password = "";
    }

    private String userName;
    private String password;
    /**
     * Charge is 0 when the new passenger sign up for first time
     */
    private int charge = 0;

    private Tickets tickets = new Tickets();


    public void printPassengersMenu() {
        System.out.println("::::::::::::::::::::::::::::::::::::::::\n" +
                "         PASSENGER MENU OPTIONS\n" +
                "::::::::::::::::::::::::::::::::::::::::\n" +
                " ......................................\n" +
                "    <1> Change password\n" +               //write data
                "    <2> Search flight tickets\n" +         //read data
                "    <3> Booking ticket\n" +                //read & write data
                "    <4> Ticket cancelation\n" +            //read & write data
                "    <5> Booked tickets\n" +                //read data
                "    <6> Add charge\n" +                    //write data
                "    <0> Sign out\n");
    }

    public void passengersMenu(Flights flights, int index) {
        int choice;
        while (true) {
            printPassengersMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1://Change password
                    changePassword();
                    break;
                case 2://Search flight tickets
                    SearchTicket searchTicket = new SearchTicket(tickets);
                    break;
                case 3://Booking ticket
                    bookingTicket(flights, index);
                    break;
                case 4://Ticket cancelation
                    ticketCancelation(flights);
                    break;
                case 5://Booked tickets
                    bookedTickets();
                    break;
                case 6://Add charge
                    System.out.println("You have " + getCharge() + " $ now");
                    System.out.println("Enter the charge amount :");
                    setCharge(scanner.nextInt());
                    System.out.println("--Done--");
                    break;
                case 0://Sign out
                    return;
            }
        }

    }

    /**
     * Cancel a ticket that user booked
     * This process is done using ticket id
     * @param flights
     */
    private void ticketCancelation(Flights flights) {
        System.out.println("Please enter your TicketId >>>");
        String ticketId = scanner.next();
        for (int i = 0; i < tickets.ticket.length; i++) {
            if (tickets.ticket[i] != null) {
                int index = tickets.ticket[i].getFlightIndex();
                if (tickets.ticket[i].getTicketId().equals(ticketId)) {
                    flights.flight[index].setReserveCount(-1);
                    int tmp = Integer.parseInt(flights.flight[index].getSeat());
                    tmp = tmp + 1;
                    flights.flight[index].setSeat(Integer.toString(tmp));
                    setCharge(Integer.parseInt(tickets.ticket[i].getPrice()));
                    tickets.ticket[i] = null;
                    System.out.println("---Ticket canceled---");
                    return;
                }
            }
        }
        System.out.println("Cannot find your TicketId!!!");
    }

    /**
     * This method print booked ticket
     */
    private void bookedTickets() {

        System.out.print("..........................................................................................................................................\n");
        System.out.printf("|%-15s |%-15s |%-15s |%-15s  |%-15s |%-15s |%-15s |%-15s |%n", "TicketId", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "Seat");
        for (int i = 0; i < tickets.ticket.length; i++) {
            if (tickets.ticket[i] != null) {
                System.out.print("..........................................................................................................................................\n");
                System.out.printf("|%-15s |%-15s |%-15s |%-15s  |%-15s |%-15s |%-15s |%-15s |%n", tickets.ticket[i].getTicketId(), tickets.ticket[i].getFlightId(), tickets.ticket[i].getOrigin(), tickets.ticket[i].getDestination(), tickets.ticket[i].getDate(), tickets.ticket[i].getTime(), tickets.ticket[i].getPrice(), tickets.ticket[i].getSeat());
            }
        }
        System.out.print("..........................................................................................................................................\n");
    }

    /**
     * Passenger change the account password
     */
    public void changePassword() {
        System.out.println("Enter your current password :");
        if (getPassword().equals(scanner.next())) {
            System.out.println("Set new password :");
            setPassword(scanner.next());
            System.out.println("--Done--");
        } else {
            System.out.println("Wrong password !!");
        }
    }

    /**
     * book the ticket by using flight id
     * @param flights
     * @param index index of array list of flights , this parameter use for build the ticket id
     */
    public void bookingTicket(Flights flights, int index) {
        flights.flightSchedule(flights);
        System.out.print("Book your ticket >>> ");
        int i = tickets.findNullTicket(); // find null ticket in tickets array
        int j = flights.searchFlight();   // search the flights by using flight id
        if (j == -1) {
            System.out.println("Wrong FlightId !!!");
            return;
        }
        int price = Integer.parseInt(flights.flight[j].getPrice());
        if (flights.flight[i].getSeat().equals("0")) {
            System.out.println("The flight is full!!");
        } else {
            if (price < getCharge()) {
                setCharge(-price);
                int tmp = Integer.parseInt(flights.flight[j].getSeat());
                flights.flight[j].setReserveCount(1);
                tickets.ticket[i] = new Ticket(flights.flight[j].getFlightId(), flights.flight[j].getOrigin(), flights.flight[j].getDestination(), flights.flight[j].getDate(), flights.flight[j].getTime(), flights.flight[j].getPrice(), flights.flight[j].getSeat());
                flights.flight[j].setSeat(Integer.toString(tmp - 1));
                tickets.ticket[i].setTicketId(index, i);
                tickets.ticket[i].setFlightIndex(j);
                System.out.print("your ticket id >> ");
                System.out.println(tickets.ticket[i].getTicketId());
                System.out.println("---Done---");
            } else {
                System.out.println("You do not have enough money to get this flight \n" +
                        "please recharge your account >>");
            }
        }

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (userName.matches(".*[a-z].*") && userName.matches(".*[A-Z].*") && userName.matches(".*[0-9].*")) {
            this.userName = userName;
        } else {
            System.out.println("Your username must contain upper and lower case letters and numbers");
            System.out.println("Enter your user name again >> ");
            this.setUserName(this.scanner.next());
        }
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {

        this.charge += charge;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.matches("[0-9]+$") && password.length() > 4) {
            this.password = password;
        } else {
            System.out.println("Your password must consist of digits (0-9) and have more than 4 digits");
            System.out.println("Enter your password again >> ");
            this.setPassword(this.scanner.next());
        }
    }
}
