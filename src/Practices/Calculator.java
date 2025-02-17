package Practices;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int  a,b,operation;
        System.out.println("Please Enter Two Numbers: ");
         a = input.nextInt();
         b = input.nextInt();
        System.out.println("Please Enter an Operator\n1-Multiplication\n2-Sum\n3-Difference\n4-Division");
        operation = input.nextInt();
        String result;
        switch (operation) {
            case 1:
                result = "The Multiplication is: " + (a * b);
                break;
            case 2:
                result = "The Sum is: " + (a + b);
                break;
            case 3:
                result = "The Difference is: " + (a - b);
                break;
            case 4:
                result = (b != 0) ? "The Division is: " + ( (double)a / b) : "Error: Division by zero!";
                break;
            default:
                result = "Invalid Operator";
        }

        System.out.println( result);

        input.close();
    }
}
