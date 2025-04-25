package CapstoneProjects.IMS;

import java.util.Scanner;

public class LoginInput {

    String email;
    String password;

    LoginInput(){
        System.out.println("Please Enter Your Email");
        Scanner sc = new Scanner(System.in);
        this.email = sc.nextLine();
        System.out.println("Please Enter Your Password");
        this.password = sc.nextLine();
    }
}
