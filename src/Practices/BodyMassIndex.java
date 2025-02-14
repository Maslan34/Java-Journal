package Practices;

import java.util.Scanner;

public class BodyMassIndex {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        float weight,height,bmi;
        System.out.println("Please Enter Weight(kg): ");
        weight = input.nextFloat();
        System.out.println("Please Enter Height(m): ");
        height = input.nextFloat();
        bmi = height/ (weight*weight);
        System.out.println("Your BMI is: "+bmi);
    }
}
