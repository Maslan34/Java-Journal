package Practices;

import java.util.Scanner;
public class Star {
    public static void main(String[] args) {
        System.out.println("Please Enter a Number to Determine Star Pattern:");
        int pattern = new Scanner(System.in).nextInt();
        for (int i = 0 ,j=1; i < pattern; i++ ,j+=2){
            System.out.print(" ".repeat(pattern-i));
            System.out.print("*".repeat(j));
            System.out.println();
        }
    }
}
