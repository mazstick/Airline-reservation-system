package src;

import java.util.Scanner;

public class SignIn {
    private String userName;
    private String password;
//    public static Flights flights = new Flights();
    Scanner scanner = new Scanner(System.in);

    public SignIn(Passengers[] passengers , Admin admin, Flights flights) {
        checkLogin(passengers , admin , flights);
    }
    public void checkLogin(Passengers[] passengers , Admin admin  , Flights flights){
        System.out.println("Enter your username :");
        this.userName = scanner.next();
        System.out.println("Enter your password :");
        this.password = scanner.next();
        if (admin.getUserName().equals(this.userName)){
            if (admin.getPassword().equals(this.password)){
                System.out.println("Login as admin....");
                admin.adminMenu(flights);
                return;
            }
        }
        for (int i = 0; i < 20; i++) {
            if (passengers[i].getUserName().equals(this.userName)) {
                if (passengers[i].getPassword().equals(this.password)){
                    System.out.println("Login as passengers....");
                    passengers[i].passengersMenu(flights , i);
                    return;
                }
                else{
                    System.out.println("The password is incorrect!!!");
                    checkLogin(passengers , admin , flights);
                }
            }

        }
        System.out.println("The username not found !!!!");
        checkLogin(passengers , admin , flights);

    }
}
