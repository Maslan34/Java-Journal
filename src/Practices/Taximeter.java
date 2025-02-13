package Practices;

import java.util.Scanner;

/**
 * @description
 * The taxi meter rate is 2.20 TL per kilometer.
 * The minimum fare is 20 TL. For fares below 20 TL, the charge will still be 20 TL.
 * The taxi meter starting fee is 10 TL.
* */

public class Taximeter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float km,price,pricePerKM=2.20f,taxiStartingFare=10;

        System.out.println("Please Enter Kilometers: ");
        km = input.nextFloat();

        price = (km*pricePerKM)+taxiStartingFare;

        System.out.println(price>=20 ? "Price for you have to pay "+price:"Price for you have to pay: 20");

    }
}
