package Practices;


import java.util.Scanner;

public class FindLowestBiggest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many numbers you want to enter: ");
        int size = input.nextInt();
        if (size < 2) {
            System.out.println("Size have to be greater than or equal to 2");
            System.exit(0);
        }


        int lowest = Integer.MAX_VALUE;
        int biggest = Integer.MIN_VALUE;

        for(int i = 0; i < size; i++) {
            System.out.println("Enter" + (i + 1) +". number: ");
            int number = input.nextInt();
            if(number < lowest)
                lowest = number;
            if(number > biggest)
                biggest = number;
        }


        System.out.println("The Lowest number: " + lowest);
        System.out.println("The Highest number: " + biggest);
    }
}
