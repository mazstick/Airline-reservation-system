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
        flightData = open(flightDataPath);
        flightData.seek(flightData.length());
        flightData.writeChars(fixedStringToWrite(flight.getFlightId()));
        flightData.writeChars(fixedStringToWrite(flight.getOrigin()));
        flightData.writeChars(fixedStringToWrite(flight.getDestination()));
        flightData.writeChars(fixedStringToWrite(flight.getDate()));
        flightData.writeChars(fixedStringToWrite(flight.getTime()));
        flightData.writeChars(fixedStringToWrite(flight.getPrice()));
        flightData.writeInt(0);  //reservation counter
        flightData.close();
    }

    public String readString(RandomAccessFile rfile) throws IOException {
        String str = "";
        for (int i = 0; i < FIXED_SIZE; i++) {
            str = str + rfile.readChar();
        }
        return str.trim();
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
