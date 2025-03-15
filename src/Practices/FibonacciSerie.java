package Practices;

import java.util.Scanner;
public class FibonacciSerie {
    public static void main(String[] args) {
        System.out.println("Please Enter a Number To Print Fibonacci Serie:");
        int fibonacci = new Scanner(System.in).nextInt();
        int a=0,b=1,c=0;
        for(int i=0 ;i < fibonacci; i++){
            System.out.print(a+ " ");
            c=a+b;
            a=b;
            b=c;
        }
    }
}
