package Practices;

import java.util.Scanner;
public class GcdLcm {
    public static void main(String[] args) {
        System.out.println("Please Enter Two Numbers To Find GCD and LCM");
        System.out.println("First Number : ");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        System.out.println("Second Number : ");
        int b = input.nextInt();

        int gcd = 1;
        for( int i= 1 ;i<= a && i<=b ;i++)
            if(a%i == 0 && b%i == 0)
                gcd = i;

        int lcm = (a*b)/gcd;
        System.out.println("GCD is: "+gcd);
        System.out.println("LCM is: "+lcm);

    }
}
