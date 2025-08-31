package Extras;

public class main {
    public static void main(String[] args) {
        Day gunPzt = Day.PAZARTESI;
        System.out.println(gunPzt.ordinal()); // Returns its index in the array.
        System.out.println(gunPzt.name()); // Returns the name of the constant.

        Day[] values = Day.values(); // Returns all constants.
        System.out.println();
        System.out.println(values.length);
        for (Day d : values) {
            System.out.println(d);
        }

        Day gun = Day.valueOf("PAZARTESI"); // Converts a String to the enum.
    }
}
