package CapstoneProjects;

import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int life = 5;
        int number = (int) (Math.random() * 101);

        System.out.println("Welcome to the Quess Number Game");

        do {
            System.out.println("Please enter a number between 0 and 100 (inclusive) ");
            int guess = input.nextInt();
            if (guess >= 0 && guess <= 100) {
                if (guess == number) {
                    System.out.println("Congratulations! You won!");
                    System.out.println("Number was " + number);
                    System.out.println("Your remaining life was " + life);
                    break;
                }
                else{
                    life--;
                    if(life == 0){
                        System.out.println("Sorry, You lost!");
                        break;
                    }
                    System.out.println("Sorry, you did not find the correct number ");
                    if (guess < number) {
                        System.out.println("Hint: Try a bigger number.");
                    } else {
                        System.out.println("Hint: Try a smaller number.");
                    }
                    System.out.println("Your remaining life is " + life);
                }
            } else {
                System.out.println("Invalid number");
            }
        }
        while (life > 0);

        input.close();

    }
}
