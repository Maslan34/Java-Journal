package Exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        /*
        System.out.println("Program started");
        Scanner sc = new Scanner(System.in);
        int a=10,b,result;
        System.out.println("Please enter a number");

        try {
            b=sc.nextInt();
            result=a/b;
        }catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception");
        }catch (InputMismatchException e ){
            System.out.println("InputMismatchException");
        }finally {
            System.out.println("Always done");
        }

        System.out.println("Program ended");

        System.out.println();
        try {
            functionTryCatch();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }


        int evenNumber = 2;
        int oddNumber = 1;

        EvenNumberException evenNumberException = new EvenNumberException();
        evenNumberException.isEven(evenNumber);
        evenNumberException.isEven(oddNumber);




         */

        try {
            functionTryCatch(1);
        }catch (EvenNumberException e){
            System.out.println(e.getClass());
        }


    }


    static void functionTryCatch(int number) throws EvenNumberException {
        System.out.println("Hello Java!");
        if(number % 2 == 0){
            throw new EvenNumberException("Error");
        }

    }
}
