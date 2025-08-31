package Practices;

import java.util.Scanner;
public class FindBiggest {
    public static void main(String[] args) {
        System.out.println("How many numbers do you want to enter?");
        Scanner input = new Scanner(System.in);
        int counter = input.nextInt(),biggest = 0;
        for(int i=0;i<counter;i++){
            System.out.println("Please enter "+(i+1)+"th number");
            int number = input.nextInt();

            if(number>biggest)
                biggest = number;
        }
        System.out.println("The largest number among the numbers you entered is: "+biggest);
    }
}
