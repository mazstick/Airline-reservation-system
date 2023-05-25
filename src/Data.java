package src;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class Data {
    protected String flightDataPath = ".\\data\\flightData.txt";
    protected String passengersDataPath = ".\\data\\passengersData.txt";
    protected String ticketDataPath = ".\\data\\ticketsData.txt";
    public RandomAccessFile open(String path ) {
        RandomAccessFile rfile;
        try {
            rfile = new RandomAccessFile(path, "rw");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rfile;
    }
    protected RandomAccessFile flightData = open(flightDataPath);

    protected RandomAccessFile passengersData = open(passengersDataPath);


    protected RandomAccessFile ticketsData = open(ticketDataPath);


}
