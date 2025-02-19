package Practices;

import java.util.Scanner;

public class ChineseZodiac {
    public static void main(String[] args) {


        System.out.println("Please Enter Your Birthday Year:");
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        if(! (year >= 1900 && year <= 2100)){
            System.out.println("Invalid Year");
            System.exit(0);
        }
        switch (year % 12) {
            case 0:
                System.out.println("You are a Monkey");
                break;
            case 1:
                System.out.println("You are a Rooster");
                break;
            case 2:
                System.out.println("You are a Dog");
                break;
            case 3:
                System.out.println("You are a Pig");
                break;
            case 4:
                System.out.println("You are a Rat");
                break;
            case 5:
                System.out.println("You are a Ox");
                break;
            case 6:
                System.out.println("You are a Tiger");
                break;
            case 7:
                System.out.println("You are a Rabbit");
                break;
            case 8:
                System.out.println("You are a Dragon");
                break;
            case 9:
                System.out.println("You are a Snake");
                break;
            case 10:
                System.out.println("You are a Horse");
                break;
            case 11:
                System.out.println("You are a Goat");
                break;
        }
        input.close();
    }
}
