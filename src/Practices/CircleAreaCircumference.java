package Practices;

import java.util.Scanner;
public class CircleAreaCircumference {
    public static void main(String[] args) {
        double area,circumference,radius;
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Radius: ");
        radius = input.nextDouble();

        area= Math.PI*Math.pow(radius,2);
        circumference=2*Math.PI*radius;
        System.out.println("The Area of Circle is: "+area+" and the Circumference is: "+circumference);
        
    }
}


