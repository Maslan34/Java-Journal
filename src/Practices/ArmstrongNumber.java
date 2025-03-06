package Practices;

import java.util.Scanner;
public class ArmstrongNumber {
    public static void main(String[] args) {
        System.out.println("Please Enter a Number To Check Armstrong Number:");
        int number = new Scanner(System.in).nextInt();
        int tmp = number,digit=0,result=0;
        while( tmp !=0){
            tmp /= 10;
            digit++;
        }
        tmp = number;
        while(tmp !=0){
            result +=  Math.pow(tmp%10,digit);
            tmp /= 10;
        }
        if(result == number)
            System.out.println("Armstrong Number");
        else
            System.out.println("Not Armstrong Number");


    }
}
