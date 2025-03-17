package Practices;

import java.util.Scanner;
public class RecursiveFibonacci {
    public static void main(String[] args) {
        System.out.println("Enter the number to check for fibonacci number: ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        int result =fibonacci(num-1); // To see the 5th index in the Fibonacci sequence, we subtracted 1 from the number.
        System.out.println(result);
    }


    static int fibonacci(int num) {
        if(num== 0)
            return 0;
        if(num == 1)
            return 1;

        return fibonacci(num-1)+fibonacci(num-2);
    }
}
