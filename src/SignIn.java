package src;

import java.util.Scanner;

public class SignIn {
    private String userName;
    private String password;
    Scanner scanner = new Scanner(System.in);

    /**
     * Sign in users
     * This constructor run checkLogin method
     * @param passengers
     * @param admin
     * @param flights
     */
    public SignIn(Passengers[] passengers , Admin admin, Flights flights) {
        checkLogin(passengers , admin , flights);
    }

    /**
     * <p>This method check username and password to log in the users<p/>
     * <p>The passenger set his/her username and password in sign up <p/>
     * <p>The admin username is "Admin" , The admin password is "Admin"<p/>
     * @param passengers
     * @param admin
     * @param flights
     */
    public void checkLogin(Passengers[] passengers , Admin admin  , Flights flights){
        System.out.println("Enter your username :");
        this.userName = scanner.next();
        System.out.println("Enter your password :");
        this.password = scanner.next();
        if (admin.getUserName().equals(this.userName) || this.userName.equals("admin")){
            if (admin.getPassword().equals(this.password) || this.userName.equals("admin")){
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
        return;

    }
}
