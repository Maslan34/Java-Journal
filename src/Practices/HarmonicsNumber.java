package Practices;

import java.util.Scanner;
public class HarmonicsNumber {
    public static void main(String[] args) {
        System.out.println("Please Enter a Number To Find Harmonics Number:");
        int input = new Scanner(System.in).nextInt();
        float sum = 0;

        for(int i = 1; i<=input;i++)
            sum+=(float)1/i;

        System.out.println("Result is : "+sum);
    }
}
