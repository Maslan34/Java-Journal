package Practices;

import java.util.Scanner;
public class RecursivePower {
    public static void main(String[] args) {
        System.out.println("Enter number to find power of a number: ");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number for base ");
        int base = input.nextInt();
        System.out.println("Enter a number for power");
        int power = input.nextInt();

        int result = rPower(base,power);
        System.out.println(result);
    }

    static int rPower(int base, int power) {
        if(power ==0)
            return 1;
        return base * rPower(base,power-1);
    }
}
