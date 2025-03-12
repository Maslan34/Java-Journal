package Practices;

import java.util.Scanner;
public class InvertedTriangle {
    public static void main(String[] args) {
        System.out.println("Please Enter a Number To Print Inverted Triangle: ");
        int number = new Scanner(System.in).nextInt();
        for(int i= number;i>=1;i--){

            System.out.print(" ".repeat(number-1)+"*".repeat(i));
            System.out.println();
        }

        System.out.println();
        System.out.println();

        for (int i = number; i >= 1; i--) {
            String spaces = " ".repeat(number - i);
            String stars = "*".repeat(2 * i - 1);
            System.out.println(spaces + stars);
        }

    }


}
