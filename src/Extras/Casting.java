package Extras;

public class Casting {

    public static void main(String[] args) {

         /*

    Widening Casting (Automatic)

    It refers to converting a smaller data type to a larger data type.
    In Widening Casting, a lower data type (smaller size) is converted to a higher data type (larger size).
    Therefore, there is no data loss.
    This is why this type of conversion happens automatically.

    byte -> short -> char -> int -> long -> float -> double

     */

        int myInt = 3;
        double myDouble = myInt; // Automatic Casting: int => double
        System.out.println(myInt); // Output: 3
        System.out.println(myDouble); // Output: 3.0

        /*
        Narrowing Casting (Manual)

        It refers to converting a larger data type to a smaller data type.

        double -> float -> long -> int -> char -> short -> byte

         */

        double myDoubleNarrow = 3.78;
        int myIntNarrow = (int) myDoubleNarrow; // Manual Casting: double => int
        System.out.println(myIntNarrow); // Output: 3
        System.out.println(myInt); // Output: 3

    }
}
