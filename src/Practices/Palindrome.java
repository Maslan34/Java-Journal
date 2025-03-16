package Practices;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Enter a number to check palindrome: ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt(), palindrome = 0;

        int temp = num;
        while (temp != 0) {
            palindrome = palindrome * 10+ temp % 10;
            temp /= 10;
        }

        if (num == palindrome)
            System.out.println("Palindrome");
        else
            System.out.println("Not a palindrome");

    }
}
