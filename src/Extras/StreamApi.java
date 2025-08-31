package Extras;

import java.util.ArrayList;
import java.util.Comparator;

public class StreamApi {
    public static void main(String[] args) {

        /*
        A flow is formed by the consecutive appearance of objects.
        By creating a stream, we can perform operations on the elements of an array or collection.
        Streams do not care how the data is stored; they only transfer the data from one place to another.
        During this transfer, one or more operations may be performed on the data.
        These operations can include filtering, sorting, or transforming the data.
        This operation does not change the source of the stream;
         */

        ArrayList<Integer> list = new ArrayList<>();
        list.add(25);
        list.add(12);
        list.add(3);
        list.add(89);
        list.add(25);
        list.add(44);
        list.add(100);
        list.add(7);
        list.add(63);

        list.stream()
                .forEach(number -> System.out.println(number));


        list.stream()
                .filter(number -> number > 60)
                .forEach(number -> System.out.println(number));

        list.stream()
                .distinct()
                .forEach(number -> System.out.println(number));

        list.stream()
                .sorted()
                .forEach(number -> System.out.println(number));

        list.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(number -> System.out.println(number));

        list.stream()
                .limit(5L)
                .forEach(number -> System.out.println(number));


        list.stream()
                .skip(5L)
                .limit(2L)
                .forEach(number -> System.out.println(number));

        long count = list.stream()
                .filter(number -> number < 40)
                .distinct()
                .count();
        System.out.println(count);

        boolean match = list.stream()
                .anyMatch(number -> number < 5);
        System.out.println(match);


        boolean match2 = list.stream()
                .allMatch(number -> number < 5);
        System.out.println(match2);

        boolean match3 = list.stream()
                .noneMatch(number -> number < 5);
        System.out.println(match3);

        list.stream()
                .map(number -> number * 2)
                .forEach(number -> System.out.println(number));

        list.stream()
                .map(number -> Math.sqrt(number))
                .forEach(number -> System.out.println(number));

    }
}
