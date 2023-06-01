package src;

import java.io.IOException;
import java.io.RandomAccessFile;

public class DataManagement extends Data {
    protected final int FIXED_SIZE = 20;

    public void writePassenger(Passengers passenger) throws IOException {
        open(passengersDataPath);
        passengersData.seek(passengersData.length());
        passengersData.writeChars(fixedStringToWrite(passenger.getUserName()));
        passengersData.writeChars(fixedStringToWrite(passenger.getPassword()));
        passengersData.writeInt(0);
        passengersData.close();
    }

    public void writeFlight(Flight flight) throws IOException {
        flightData.writeChars(fixedStringToWrite(flight.getFlightId()));
        flightData.writeChars(fixedStringToWrite(flight.getOrigin()));
        flightData.writeChars(fixedStringToWrite(flight.getDestination()));
        flightData.writeChars(fixedStringToWrite(flight.getDate()));
        flightData.writeChars(fixedStringToWrite(flight.getTime()));
        flightData.writeChars(fixedStringToWrite(flight.getPrice()));
        flightData.writeChars(fixedStringToWrite(flight.getSeat()));
        flightData.writeInt(0);  //reservation counter
        flightData.close();
    }
    public void writeTicket(Ticket ticket) throws IOException {
        ticketsData.writeChars(fixedStringToWrite(ticket.getFlightId()));
        ticketsData.writeChars(fixedStringToWrite(ticket.getOrigin()));
        ticketsData.writeChars(fixedStringToWrite(ticket.getDestination()));
        ticketsData.writeChars(fixedStringToWrite(ticket.getDate()));
        ticketsData.writeChars(fixedStringToWrite(ticket.getTime()));
        ticketsData.writeChars(fixedStringToWrite(ticket.getPrice()));
        ticketsData.writeChars(fixedStringToWrite(ticket.getSeat()));
    }
    public String readString(RandomAccessFile rfile) throws IOException {
        String str = "";
        for (int i = 0; i < FIXED_SIZE; i++) {
            str = str + rfile.readChar();
        }
        return str.trim();
    }

    public boolean searchFlightById(String flightId) throws IOException {
        for (int i = 0; i < flightData.length() / (14 * FIXED_SIZE + 4); i++) {
            flightData.seek(i * (14 * FIXED_SIZE + 4));
            if (readString(flightData).equals(flightId)) {
                flightData.seek(flightData.getFilePointer() - 2 * FIXED_SIZE);
                return true;
            }
        }
        return false;
    }

    public String fixedStringToWrite(String st) {
        while (true) {
            if (st.length() < FIXED_SIZE) {
                st += " ";
            } else {
                break;
            }
        }
        return st.substring(0, FIXED_SIZE);
    }

}
