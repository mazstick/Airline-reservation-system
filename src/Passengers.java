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

    public void passengersMenu(Flights flights) {
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
                    bookingTicket(flights);
                    break;
                case 4:
                    break;
                case 5:
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

    public void bookingTicket(Flights flights) {
        flights.flightSchedules(flights);
        System.out.print("Book your ticket >>> ");
        int i = flights.searchFlight();
        int j = tickets.findNullTicket();

        if (flights.flight[i].getSeat().equals("0")) {
            System.out.println("The flight is full!!");
        } else {
            if (Integer.valueOf(flights.flight[i].getPrice()) < getCharge()) {
                
            }
            else {
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
