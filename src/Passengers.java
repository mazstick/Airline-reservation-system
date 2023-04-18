package src;

import java.util.Scanner;

public class Passengers {
    public Scanner scanner = new Scanner(System.in);

    public Passengers() {
        this.userName = "";
        this.password = "";
    }

    private String userName;
    private String password;
    private int charge = 0;
    private Tickets tickets = new Tickets();


    public void printPassengersMenu() {
        System.out.println("::::::::::::::::::::::::::::::::::::::::\n" +
                "         PASSENGER MENU OPTIONS\n" +
                "::::::::::::::::::::::::::::::::::::::::\n" +
                " ......................................\n" +
                "    <1> Change password\n" +
                "    <2> Search flight tickets\n" +
                "    <3> Booking ticket\n" +
                "    <4> Ticket cancelation\n" +
                "    <5> Booked tickets\n" +
                "    <6> Add charge\n" +
                "    <0> Sign out\n");
    }

    public void passengersMenu(Flights flights, int index) {
        int choice;
        while (true) {
            printPassengersMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    changePassword();
                    break;
                case 2:
                    break;
                case 3:
                    bookingTicket(flights, index);
                    break;
                case 4:
                    ticketCancelation(flights);
                    break;
                case 5:
                    bookedTickets();
                    break;
                case 6:
                    System.out.println("You have " + getCharge() + " $ now");
                    System.out.println("Enter the charge amount :");
                    setCharge(scanner.nextInt());
                    System.out.println("--Done--");
                    break;
                case 0:
                    return;
            }
        }

    }

    private void ticketCancelation(Flights flights) {
        System.out.println("Please enter your TicketId >>>");
        String ticketId = scanner.next();
        for (int i = 0; i < tickets.ticket.length; i++) {
            if (tickets.ticket[i] != null) {
                if (tickets.ticket[i].getTicketId().equals(ticketId)) {
                    flights.flight[tickets.ticket[i].getFlightIndex()].setReserveCount(-1);
                    int tmp = Integer.parseInt(flights.flight[tickets.ticket[i].getFlightIndex()].getSeat());
                    tmp = tmp + 1;
                    flights.flight[tickets.ticket[i].getFlightIndex()].setSeat(Integer.toString(tmp));
                    setCharge(Integer.parseInt(tickets.ticket[i].getPrice()));
                    tickets.ticket[i] = null;
                    System.out.println("---Ticket canceled---");
                    return;
                }
            }
        }
        System.out.println("Cannot find your TicketId!!!");
    }

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

    public void bookingTicket(Flights flights, int index) {
        flights.flightSchedules(flights);
        System.out.print("Book your ticket >>> ");
        int i = tickets.findNullTicket();
        int j = flights.searchFlight();
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
                flights.flight[j].setSeat(Integer.toString(tmp - 1));
                flights.flight[j].setReserveCount(1);
                tickets.ticket[i] = new Ticket(flights.flight[j].getFlightId(), flights.flight[j].getOrigin(), flights.flight[j].getDestination(), flights.flight[j].getDate(), flights.flight[j].getTime(), flights.flight[j].getPrice(), flights.flight[j].getSeat());
                tickets.ticket[i].setTicketId(index, i);
                tickets.ticket[i].setFlightIndex(j);
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
