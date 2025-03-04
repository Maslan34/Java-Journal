package Practices;

import java.util.Scanner;
public class PowCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter a Number for Base:");
        int base = input.nextInt();
        System.out.println("Please Enter a Number for Power:");
        int pow = input.nextInt();

        int result = 1;

        for(int i = 1; i <= pow; ++i)
            result *= base;

        System.out.println("Result is: "+result);

        input.close();
    }
}
