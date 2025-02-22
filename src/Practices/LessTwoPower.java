package Practices;

import java.util.Scanner;
public class LessTwoPower {
    public static void main(String[] args) {
        System.out.println("Please Enter a Number:");
        int number = new Scanner(System.in).nextInt();
        for (int check= 2 ;number>=check;check*=2)
            System.out.println(check);

    }
}
