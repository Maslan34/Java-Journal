package Practices;

import java.util.Scanner;
public class EvenMultipleOf4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number,sum=0;
        do{
            System.out.println("Please Enter a Number:");
            number = input.nextInt();
            if(number% 2 == 0 &&  number % 4 ==0 )
                sum += number;

        }while( number>=0 );


        System.out.println("The Sum of Even Multiple of 4 is: "+sum);




    }
}
