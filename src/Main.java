package src;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Admin admin = new Admin();
    public static Flight[] flight = new Flight[20];
    public static Flight f = new Flight();
    public static void main(String[] args) {

        Passengers[] passengers = new Passengers[20];
        for (int i = 0; i < 20; i++) {
            passengers[i] = new Passengers();
        }
        flightLib();
        f.flightSchedules(flight);

        int counter = 0;
        while (true) {
            printMainMenue();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    SignIn signIn = new SignIn(passengers , admin);
                    break;
                case 2:
                    SignUp signUp = new SignUp();
                    passengers[counter].setUserName(signUp.getUserName());
                    passengers[counter].setPassword(signUp.getPassword());
                    counter++;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

    public static void printMainMenue() {
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                "           WELCOME TO AIRELINE RESERVATION SYSTEM\n" +
                "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n" +
                "..........................MENU OPTIONS........................\n\n" +
                "    <1> Sign in\n" +
                "    <2> Sign up \n");
    }
    public static void flightLib(){
        flight[0] = new Flight("YT-30","yazd", "tehran", "1402-01-20", "13:15", "500000", "300" );
        flight[1] = new Flight("MG-43","mashhad", "ghazvin", "1402-01-22", "12:30", "2000000","123");
        flight[2]= new Flight("SA-90","sari", "ardabil", "1402-01-23", "2:45", "400000", "200" );
        flight[3] = new Flight("GB-37","ghom", "bandarabbas", "1402-01-30", "14:35", "320000", "110" );
        flight[4] = new Flight("RT-78","rasht", "tabriz", "1402-02-03", "14:15", "450000", "420" );
    }
}
