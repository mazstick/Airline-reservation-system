package src;

import java.io.IOException;

public class DataManagement extends Data {
    private final int FIXED_SIZE = 20;

    public void writePassenger(Passengers passenger) throws IOException {
        passengersData.seek(passengersData.length());
        passengersData.writeChars(fixedStringToWrite(passenger.getUserName()));
        passengersData.writeChars(fixedStringToWrite(passenger.getPassword()));
    }

    private String fixedStringToWrite(String st) {
        while (true) {
            if (st.length() < FIXED_SIZE) {
                st += " ";
            }
            else{
                break;
            }
        }
        return st.substring(0,FIXED_SIZE);
    }

}
