package Practices;

import java.util.Scanner;

public class PlaneTicket {
    public static void main(String[] args) {

        int age, Km, tripType;
        float price=0,PRICE_PER_KM=0.10f;

        System.out.println("Please Enter Age: ");
        Scanner input = new Scanner(System.in);
        age = input.nextInt();
        if(!(age>0 && age<=120 ) ){
            System.out.println("Age must be greater than 0 and less than 120");
            System.exit(0);
        }

        System.out.println("Please Enter Your Trip's Long");
        Km = input.nextInt();
        if(!(Km>0) ){
            System.out.println("Km must be greater than 0");
            System.exit(0);
        }

        System.out.println("Please Enter Your Trip Type:\n1-One Way\n2-Round Trip");
        tripType = input.nextInt();
        if(!(tripType == 1 || tripType == 2) ){
            System.out.println("Invalid Trip Type");
            System.exit(0);
        }

        price = (PRICE_PER_KM*Km);

        if(age<=12)
            price *=  0.50f;
        else if (age>12 && age<=24)
            price *=  0.90f;
        else if(age>=65)
            price *=  0.70f;



        if (tripType == 2) {
            price *= 2;
            price *= 0.80f;
        }

        System.out.printf("Your Ticket Price is: %.2f TL%n", price);

        input.close();


    }
}
