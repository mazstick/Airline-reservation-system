package src;

import java.util.Scanner;

public class SignUp {
    public Scanner scanner;
    private String userName;
    private String password;

    public SignUp() {
        this.scanner = new Scanner(System.in);
        System.out.println("Enter your user name :");
        this.setUserName(this.scanner.next());
        System.out.println("Enter your password  :");
        this.setPassword(this.scanner.next());
    }

    public void setUserName(String userName) {
        if (userName.matches(".*[a-z].*") && userName.matches(".*[A-Z].*") && userName.matches(".*[0-9].*")) {
            this.userName = userName;
        } else {
            System.out.println("Your username must contain upper and lower case letters and numbers");
            System.out.println("Enter your user name again >> ");
            this.setUserName(this.scanner.next());
        }

    }
    public void setPassword(String password) {
        if (password.matches("[0-9]+$") && password.length() > 4) {
            this.password = password;
        } else {
            System.out.println("Your password must consist of digits (0-9) and have more than 4 digits");
            System.out.println("Enter your password again >> ");
            this.setPassword(this.scanner.next());
        }

    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
