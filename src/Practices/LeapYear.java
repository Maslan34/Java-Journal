package Practices;

import java.util.Scanner;
public class LeapYear {
    public static void main(String[] args) {
        System.out.print("Enter a year: ");
        int year = new Scanner(System.in).nextInt();
        if( year%400 == 0 || (year%4 == 0 && year%100 != 0) )
            System.out.println("Leap Year");
        else
            System.out.println("Not Leap Year");
    }
}
