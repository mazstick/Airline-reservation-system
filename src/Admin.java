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
     * <p>
     * //     * @param flights array of flights
     */
//    public void update(Flights flights) throws IOException {
//
//        if (flights.flight[i].getReserveCount() > 0) {
//            System.out.println("The flight is booked, you cannot update it !!!");
//            return;
//        }
//
//        String strtmp = new String();
//        System.out.print(".........................................................................................................................\n");
//        System.out.printf("|%-15s |%-15s |%-15s  |%-15s |%-15s |%-15s |%-15s |\n", flights.flight[i].getFlightId(), flights.flight[i].getOrigin(), flights.flight[i].getDestination(), flights.flight[i].getDate(), flights.flight[i].getTime(), flights.flight[i].getPrice(), flights.flight[i].getSeat());
//        System.out.print(".........................................................................................................................\n");
//        System.out.println("Set new FlightId :\n" + "   <*>skip");
//        strtmp = scanner.next();
//        if (!Objects.equals(strtmp, "*")) {
//            flights.flight[i].setFlightId(strtmp, flights);
//        }
//        System.out.println("Set new Origin :\n" + "   <*>skip");
//        strtmp = scanner.next();
//        if (!Objects.equals(strtmp, "*")) {
//            flights.flight[i].setOrigin(strtmp);
//        }
//        System.out.println("Set new Destination :\n" + "   <*>skip");
//        strtmp = scanner.next();
//        if (!Objects.equals(strtmp, "*")) {
//            flights.flight[i].setDestination(strtmp);
//        }
//        System.out.println("Set new Date :\n" + "   <*>skip");
//        strtmp = scanner.next();
//        if (!Objects.equals(strtmp, "*")) {
//            flights.flight[i].setDate(strtmp);
//        }
//        System.out.println("Set new Time :\n" + "   <*>skip");
//        strtmp = scanner.next();
//        if (!Objects.equals(strtmp, "*")) {
//            flights.flight[i].setTime(strtmp);
//        }
//        System.out.println("Set new Price :\n" + "   <*>skip");
//        strtmp = scanner.next();
//        if (!Objects.equals(strtmp, "*")) {
//            flights.flight[i].setPrice(strtmp);
//        }
//        System.out.println("Set new Seat :\n" + "   <*>skip");
//        strtmp = scanner.next();
//        if (!Objects.equals(strtmp, "*")) {
//            flights.flight[i].setSeat(strtmp);
//        }
//        System.out.println("Flight updated >>");
//        System.out.print(".........................................................................................................................\n");
//        System.out.printf("|%-15s |%-15s |%-15s  |%-15s |%-15s |%-15s |%-15s |\n", flights.flight[i].getFlightId(), flights.flight[i].getOrigin(), flights.flight[i].getDestination(), flights.flight[i].getDate(), flights.flight[i].getTime(), flights.flight[i].getPrice(), flights.flight[i].getSeat());
//        System.out.print(".........................................................................................................................\n");
//    }
    private void update() throws IOException {
        flightData = open(flightDataPath);
        System.out.println("Enter FlightId :");
        if (!searchFlightById(scanner.next())) {
            System.out.println("Wrong FlightId !!!");
            flightData.close();
            return;
        }
        flightData.seek(flightData.getFilePointer() + 14 * FIXED_SIZE);
        if (flightData.readInt() > 0) {
            System.out.println("The flight is booked, you cannot update it !!!");
            flightData.close();
            return;
        }
        flightData.seek(flightData.getFilePointer() - (14 * FIXED_SIZE + 4));
        String strtmp = new String();
        System.out.print(".........................................................................................................................\n");
        System.out.printf("|%-15s |%-15s |%-15s  |%-15s |%-15s |%-15s |%-15s |\n", readString(flightData), readString(flightData), readString(flightData), readString(flightData), readString(flightData), readString(flightData), readString(flightData));
        System.out.print(".........................................................................................................................\n");
        flightData.seek(flightData.getFilePointer() - (14 * FIXED_SIZE));
        System.out.println("Set new FlightId :\n" + "   <*>skip");
        strtmp = scanner.next();
        if (!Objects.equals(strtmp, "*")) {
            flightData.writeChars(fixedStringToWrite(strtmp));
        } else {
            flightData.seek(flightData.getFilePointer() + 2 * FIXED_SIZE);
        }
        System.out.println("Set new Origin :\n" + "   <*>skip");
        strtmp = scanner.next();
        if (!Objects.equals(strtmp, "*")) {
            flightData.writeChars(fixedStringToWrite(strtmp));
        } else {
            flightData.seek(flightData.getFilePointer() + 2 * FIXED_SIZE);
        }
        System.out.println("Set new Destination :\n" + "   <*>skip");
        strtmp = scanner.next();
        if (!Objects.equals(strtmp, "*")) {
            flightData.writeChars(fixedStringToWrite(strtmp));
        } else {
            flightData.seek(flightData.getFilePointer() + 2 * FIXED_SIZE);
        }
        System.out.println("Set new Date :\n" + "   <*>skip");
        strtmp = scanner.next();
        if (!Objects.equals(strtmp, "*")) {
            flightData.writeChars(fixedStringToWrite(strtmp));
        } else {
            flightData.seek(flightData.getFilePointer() + 2 * FIXED_SIZE);
        }
        System.out.println("Set new Time :\n" + "   <*>skip");
        strtmp = scanner.next();
        if (!Objects.equals(strtmp, "*")) {
            flightData.writeChars(fixedStringToWrite(strtmp));
        } else {
            flightData.seek(flightData.getFilePointer() + 2 * FIXED_SIZE);
        }
        System.out.println("Set new Price :\n" + "   <*>skip");
        strtmp = scanner.next();
        if (!Objects.equals(strtmp, "*")) {
            flightData.writeChars(fixedStringToWrite(strtmp));
        } else {
            flightData.seek(flightData.getFilePointer() + 2 * FIXED_SIZE);
        }
        System.out.println("Set new Seat :\n" + "   <*>skip");
        strtmp = scanner.next();
        if (!Objects.equals(strtmp, "*")) {
            flightData.writeChars(fixedStringToWrite(strtmp));
        } else {
            flightData.seek(flightData.getFilePointer() + 2 * FIXED_SIZE);
        }
        flightData.seek(flightData.getFilePointer() - 14 * FIXED_SIZE);
        System.out.println("" + flightData.getFilePointer());
        System.out.println("Flight updated >>");
        System.out.print(".........................................................................................................................\n");
        System.out.printf("|%-15s |%-15s |%-15s  |%-15s |%-15s |%-15s |%-15s |\n", readString(flightData), readString(flightData), readString(flightData), readString(flightData), readString(flightData), readString(flightData), readString(flightData));
        System.out.print(".........................................................................................................................\n");
        flightData.close();
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
//                    update(flights);
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
                    flightSchedule();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Wrong command!!!");
                    break;

            }

        }
    }
//=======================================   flight schedule   =============================

    public void flightSchedule() throws IOException {
        flightData = open(flightDataPath);
        System.out.print(".........................................................................................................................\n");
        System.out.printf("|%-15s |%-15s |%-15s  |%-15s |%-15s |%-15s |%-15s |\n", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "Seat");
        for (int i = 0; i < flightData.length() / (14 * FIXED_SIZE + 4); i++) {
            flightData.seek(i * (14 * FIXED_SIZE + 4));
            System.out.print(".........................................................................................................................\n");
            System.out.printf("|%-15s |%-15s |%-15s  |%-15s |%-15s |%-15s |%-15s |\n", readString(flightData), readString(flightData), readString(flightData), readString(flightData), readString(flightData), readString(flightData), readString(flightData));
        }
        System.out.print(".........................................................................................................................\n");
        flightData.close();
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
        flightData = open(flightDataPath);
        flightData.seek(flightData.length());
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

    private void remove() throws IOException {
        flightData = open(flightDataPath);
        System.out.println("Enter FlightId :");
        if (!searchFlightById(scanner.next())) {
            System.out.println("Wrong FlightId !!!");
            flightData.close();
            return;
        }
        flightData.seek(flightData.getFilePointer() + (14 * FIXED_SIZE));
        int tmp = flightData.readInt();
//        System.out.println("reservation : "+tmp);
//        System.out.println("is here : " + flightData.getFilePointer());
        if (tmp > 0) {
            System.out.println("The flight is booked, you cannot remove it !!!");
            flightData.close();
            return;
        }

//        System.out.println(((flightData.length() - flightData.getFilePointer()) / (14 * FIXED_SIZE + 4)));
        for (int i = 0; i <= ((flightData.length() - flightData.getFilePointer()) / (14 * FIXED_SIZE + 4)); i++) {
            String strtmp = "";
            int inttmp;
//            System.out.println("ok");
            for (int j = 0; j < 7 * FIXED_SIZE; j++) {
                strtmp += flightData.readChar();
            }
            inttmp = flightData.readInt();
//            System.out.println("1 :"+flightData.getFilePointer());
            flightData.seek(flightData.getFilePointer() - 2 * (14 * FIXED_SIZE + 4));

//            System.out.println("2 :"+flightData.getFilePointer());
            flightData.writeChars(strtmp);
            flightData.writeInt(inttmp);
//            System.out.println(strtmp + "  " + inttmp);

//            System.out.println("3 :"+flightData.getFilePointer());
            flightData.seek(flightData.getFilePointer() + (14 * FIXED_SIZE + 4));

//            System.out.println("4 :"+flightData.getFilePointer());
        }
        flightData.setLength(flightData.length() - (14 * FIXED_SIZE + 4));
        flightData.close();
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}

