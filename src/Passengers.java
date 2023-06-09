package src;

import java.io.IOException;
import java.util.Scanner;

public class Passengers extends DataManagement {
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

    private final Tickets tickets = new Tickets();


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

    public void passengersMenu(Flights flights, int index) throws IOException {
        int choice;
        while (true) {
            printPassengersMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1://Change password
                    changePassword();
                    break;
                case 2://Search flight tickets
//                    SearchTicket searchTicket = new SearchTicket(tickets);
                    break;
                case 3://Booking ticket
                    bookingTicket(flights, index);
                    break;
                case 4://Ticket cancelation
                    ticketCancelation(flights);
                    break;
                case 5://Booked tickets
                    bookedTicket();
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

    public void passengersMenu(long passengerPassPointer) throws IOException {
        passengersData = open(passengersDataPath);
        passengersData.seek(passengerPassPointer - (4 * FIXED_SIZE));
        setUserName(readString(passengersData));
        passengersData.close();
        String choice;
        while (true) {
            printPassengersMenu();
            choice = scanner.next();
            switch (choice) {
                case "1"://Change password
                    passengersData = open(passengersDataPath);
                    passengersData.seek(passengerPassPointer - (2 * FIXED_SIZE));
                    changePassword();
                    break;
                case "2"://Search flight tickets
                    SearchTicket searchTicket = new SearchTicket(getUserName());
                    System.out.println("Not build yet!!");
                    break;
                case "3"://Booking ticket
                    bookingTicket(passengerPassPointer);
                    break;
                case "4"://Ticket cancelation
                    ticketCancelation(passengerPassPointer);
                    break;
                case "5"://Booked tickets
                    bookedTickets();
                    break;
                case "6"://Add charge
                    addCharge(passengerPassPointer);
                    break;
                case "0"://Sign out
                    return;
                default:
                    System.out.println("Wrong choice!!");
                    break;
            }
        }
    }


    private void addCharge(long pos) throws IOException {
        passengersData = open(passengersDataPath);
        passengersData.seek(pos);
        System.out.println("You have " + passengersData.readInt() + " $ now");
        System.out.println("Enter the charge amount :");
        passengersData.seek(pos);
        int tmp = scanner.nextInt();
        passengersData.writeInt(tmp);
        passengersData.close();
        System.out.println("--Done--");
    }

    /**
     * Cancel a ticket that user booked
     * This process is done using ticket id
     *
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

    private void ticketCancelation(long passengerPassPointer) throws IOException {
        System.out.println("Please enter your TicketId >>>");
        String ticketId = scanner.next();
        ticketsData = open(ticketDataPath);
        for (int i = 0; i < ticketsData.length() / (18 * FIXED_SIZE); i++) {
            ticketsData.seek(i * 18 * FIXED_SIZE + 2 * FIXED_SIZE);
            String tmp = readString(ticketsData);
            if (ticketId.equals(tmp)) {

                removeLine(i * 18 * FIXED_SIZE);
                System.out.println("--Done--");
                return;
            }
        }
        System.out.println("Ticket id not found !!!");

    }

    private void removeLine(long pos) throws IOException {
        ticketsData.seek(pos);
//        System.out.println("h :" + ticketsData.getFilePointer());
//        System.out.println((ticketsData.length() - ticketsData.getFilePointer()) / (18 * FIXED_SIZE));
        int len = (int) ((ticketsData.length() - ticketsData.getFilePointer()) / (18 * FIXED_SIZE));
        for (int i = 1; i < len; i++) {
            ticketsData.seek(ticketsData.getFilePointer() + 18 * FIXED_SIZE);
//            System.out.println(ticketsData.getFilePointer());
            String tmp = "";
            for (int j = 0; j < 9 * FIXED_SIZE; j++) {
                tmp += ticketsData.readChar();
            }
            ticketsData.seek(ticketsData.getFilePointer() - (2 * (18 * FIXED_SIZE)));
            ticketsData.writeChars(tmp);
        }
        ticketsData.setLength(ticketsData.length() - 18 * FIXED_SIZE);
        ticketsData.close();
    }

    /**
     * This method print booked ticket
     */
    private void bookedTicket() {

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

    private void bookedTickets() throws IOException {
        ticketsData = open(ticketDataPath);
        System.out.print("..........................................................................................................................................\n");
        System.out.printf("|%-15s |%-15s |%-15s |%-15s  |%-15s |%-15s |%-15s |%-15s |%n", "TicketId", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "Seat");

        for (int i = 0; i < ticketsData.length() / (18 * FIXED_SIZE); i++) {
            ticketsData.seek((long) i * 18 * FIXED_SIZE);
            if (readString(ticketsData).equals(getUserName())) {
                System.out.print("..........................................................................................................................................\n");
                System.out.printf("|%-15s |%-15s |%-15s |%-15s  |%-15s |%-15s |%-15s |%-15s |%n", readString(ticketsData), readString(ticketsData), readString(ticketsData), readString(ticketsData), readString(ticketsData), readString(ticketsData), readString(ticketsData), readString(ticketsData));

            }
        }
        System.out.print("..........................................................................................................................................\n");
        ticketsData.close();
    }

    /**
     * Passenger change the account password
     */
//    public void changePassword() {
//        System.out.println("Enter your current password :");
//        if (getPassword().equals(scanner.next())) {
//            System.out.println("Set new password :");
//            setPassword(scanner.next());
//            System.out.println("--Done--");
//        } else {
//            System.out.println("Wrong password !!");
//        }
//    }
    public void changePassword() throws IOException {
//        passengersData = open(path);
        System.out.println("Enter your current password :");
        if (readString(passengersData).equals(scanner.next())) {
            System.out.println("Set new password :");
            passengersData.seek(passengersData.getFilePointer() - (2 * FIXED_SIZE));
            passengersData.writeChars(fixedStringToWrite(scanner.next()));
            System.out.println("--Done--");
            passengersData.close();
        } else {
            System.out.println("Wrong password !!");
            passengersData.close();
        }
    }

    /**
     * book the ticket by using flight id
     *
     * @param flights
     * @param index   index of array list of flights , this parameter use for build the ticket id
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

    public void bookingTicket(long pos) throws IOException {
        Admin admin = new Admin();
        admin.flightSchedule();
        ticketsData = open(ticketDataPath);
        ticketsData.seek(ticketsData.length());
        flightData = open(flightDataPath);
        System.out.println("Enter FlightId :");
        String tmp = scanner.next();
        if (!searchFlightById(tmp)) {
            System.out.println("Wrong FlightId !!!");
            flightData.close();
            ticketsData.close();
            return;
        }
//        System.out.println("flightdata pointer : " + flightData.getFilePointer());
        flightData.seek(flightData.getFilePointer() + (12 * FIXED_SIZE));
        if (readString(flightData).equals("0")) {
            System.out.println("The flight is full!!");
            flightData.close();
            ticketsData.close();
            return;
        }
        flightData.seek(flightData.getFilePointer() - (4 * FIXED_SIZE));
        int x = Integer.parseInt(readString(flightData));
        flightData.seek(flightData.getFilePointer() - (12 * FIXED_SIZE));
        passengersData = open(passengersDataPath);
        passengersData.seek(pos);
        int y = passengersData.readInt();
        if (y - x < 0) {
            System.out.println("You do not have enough money to get this flight \n" +
                    "please recharge your account >>");
            flightData.close();
            passengersData.close();
            ticketsData.close();
            return;
        } else {
            passengersData.seek(passengersData.getFilePointer() - 4);
            passengersData.writeInt(y - x);
            passengersData.close();
        }
        ticketsData.writeChars(fixedStringToWrite(getUserName()));              //username
        ticketsData.writeChars(fixedStringToWrite(tmp + "-" + getUserName()));  //ticket id
        System.out.println("Your ticket id >> " + fixedStringToWrite(tmp + "-" + getUserName()));
        Ticket ticket = new Ticket(readString(flightData), readString(flightData), readString(flightData), readString(flightData), readString(flightData), readString(flightData), readString(flightData));
        writeTicket(ticket);
        int reservationCounter = flightData.readInt();
//        System.out.println("reservation : " + (reservationCounter + 1));
//        System.out.println("flightdata pointer : " + flightData.getFilePointer());
        flightData.seek(flightData.getFilePointer() - (2 * FIXED_SIZE + 4));
        int tmp1 = Integer.parseInt(readString(flightData));
        flightData.seek(flightData.getFilePointer() - (2 * FIXED_SIZE));
        flightData.writeChars(fixedStringToWrite(String.valueOf(tmp1-1)));
        flightData.writeInt((reservationCounter + 1));
        ticketsData.close();
        flightData.close();
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
