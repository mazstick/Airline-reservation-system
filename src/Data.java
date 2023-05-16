package src;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class Data {
    protected RandomAccessFile flightData;
    {
        try {
            flightData = new RandomAccessFile(".\\data\\flightData.dat" ,"rw");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    protected RandomAccessFile passengersData;
    {
        try {
            passengersData = new RandomAccessFile(".\\data\\passengersData.dat" ,"rw");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    protected RandomAccessFile ticketsData;
    {
        try {
            ticketsData = new RandomAccessFile(".\\data\\ticketsData.dat" , "rw");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
