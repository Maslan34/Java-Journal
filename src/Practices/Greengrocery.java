package Practices;

import java.util.Scanner;


public class Greengrocery {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float pear,apple,tomato,banana,aubergine,pearPrice=2.14f,applePrice=3.67f,tomatoPrice=1.11f,bananaPrice=0.95f,auberginePrice=5.00f;
        System.out.println("How many kilograms of pears did you buy");
        pear = input.nextFloat();
        System.out.println("How many kilograms of apples did you buy");
        apple = input.nextFloat();
        System.out.println("How many kilograms of tomatoes did you buy");
        tomato = input.nextFloat();
        System.out.println("How many kilograms of bananas did you buy");
        banana = input.nextFloat();
        System.out.println("How many kilograms of aubergine did you buy");
        aubergine = input.nextFloat();

        float total = pear*pearPrice+apple*applePrice+tomato*tomatoPrice+banana*bananaPrice+aubergine*auberginePrice;
        System.out.println("The total price of your grocery is: "+total);

        input.close();


    }
}
