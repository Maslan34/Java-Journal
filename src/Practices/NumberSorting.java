package Practices;

import java.util.Scanner;
public class NumberSorting {
    public static void main(String[] args) {

        System.out.println("Please Enter First Number: ");
        int a = new Scanner(System.in).nextInt();
        System.out.println("Please Enter Second Number: ");
        int b = new Scanner(System.in).nextInt();
        System.out.println("Please Enter Third Number: ");
        int c = new Scanner(System.in).nextInt();

        if(a>b && a>c)
            System.out.println("First Number is Biggest");
        else if (b>a && b>c)
            System.out.println("Second Number is Biggest");
        else
            System.out.println("Third Number is Biggest");
    }
}
