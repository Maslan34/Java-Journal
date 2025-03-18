package Practices;

import java.util.Scanner;
public class RecursivePrime {
    public static void main(String[] args) {

        System.out.println("Enter number to check if it is prime or not: ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        boolean isPrime =  isPrime(num,2);
        System.out.println(isPrime ? "Prime" : "Not Prime");

    }

    static boolean isPrime(int num,int n) {
        if(num<2)
            return false;
        if(n==num)
            return true;
        if(num%n == 0)
            return false;
        return isPrime(num,n+1);

    }
}
