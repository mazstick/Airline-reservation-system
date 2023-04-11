package src;

import java.util.Scanner;

public class SignIn {
    private String userName;
    private String password;
    Scanner scanner = new Scanner(System.in);

    public SignIn(Passengers[] passengers , Admin admin ) {
        checkLogin(passengers , admin );
    }
    public void checkLogin(Passengers[] passengers , Admin admin ){
        System.out.println("Enter your username :");
        this.userName = scanner.next();
        System.out.println("Enter your password :");
        this.password = scanner.next();
        if (admin.getUserName().equals(this.userName)){
            if (admin.getPassword().equals(this.password)){
                System.out.println("Login as admin....");
                admin.adminMenu();
                return;
            }
        }
        for (int i = 0; i < 20; i++) {
            if (passengers[i].getUserName().equals(this.userName)) {
                if (passengers[i].getPassword().equals(this.password)){
                    System.out.println("Login as passengers....");
                    return;
                }
                else{
                    System.out.println("The password is incorrect!!!");
                    checkLogin(passengers , admin);
                }
            }

        }
        System.out.println("The username not found !!!!");
        checkLogin(passengers , admin );

    }
}
