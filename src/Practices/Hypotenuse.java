
package Practices;

import java.util.Scanner;


public class Hypotenuse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a,b,c;
        System.out.println("Please Enter Side A: ");
        a = input.nextDouble();
        System.out.println("Please Enter Side B: ");
        b = input.nextDouble();
        c=  Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
        System.out.println("The Hypotenuse is: "+c);
    }
}
