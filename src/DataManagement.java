package src;

import java.io.IOException;
import java.io.RandomAccessFile;

public class DataManagement extends Data {
    protected final int FIXED_SIZE = 20;

    public void writePassenger(Passengers passenger) throws IOException {
        passengersData.seek(passengersData.length());
        passengersData.writeChars(fixedStringToWrite(passenger.getUserName()));
        passengersData.writeChars(fixedStringToWrite(passenger.getPassword()));
        passengersData.close();
    }

    public String readPassengerString() throws IOException {
        String str = "";
        for (int i = 0; i < FIXED_SIZE; i++) {
            str = str + passengersData.readChar();
        }
        return str.trim();
    }

    private String fixedStringToWrite(String st) {
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
