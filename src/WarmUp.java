import java.util.Scanner;

public class WarmUp {
    public static void main(String[] args) {
        /* Primitives Data Types

        byte b = 127;
        short s = 32767;
        int i = 2147483647;
        long l = 9223372036854775807L;
        float f = 3.14f;
        double d = 3.14159265358979323846;
        boolean bool = true;
        char c = 'A';
        String str = "Hello World!";

         */

        /*
        float test =3.15; // Error
        float test2 =3; // 3.00
        System.out.println(test);
        */

        /*
        char a = 97;
        char A= 'A';
        System.out.println(a);

         */

        /*
        int x = 1, y = 2, r=3;
        r *= x + y;
        System.out.println( r);

         */

        /*
        byte b = 0;
        int a = b++;
        System.out.println(a);

        byte c = 0;
        int d = c++;
        System.out.println(c);
        System.out.println(d);

         */

        /*
        int m = -12, n = -5 ;
        System.out.println(m%n);

         */

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int userInput = input.nextInt();
        System.out.println("You entered: " + userInput);

    }
}