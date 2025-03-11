package Practices;

import java.util.Scanner;
public class PerfectNumber {
    public static void main(String[] args) {
        System.out.println("Please Enter a Number To Check Whether It's Perfect Number Or Not:");
        int number = new Scanner(System.in).nextInt(),sum=0;

        for(int i= 1 ;i<number;i++){
            if(number%i==0)
                sum+=i;
        }
        if(sum==number)
            System.out.println("Perfect Number");
        else
            System.out.println("Not Perfect Number");
    }
}
