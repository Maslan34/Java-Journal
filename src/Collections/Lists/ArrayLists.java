package Collections.Lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayLists {
    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(null);

        System.out.println(arr);
        System.out.println("Iterator");
        Iterator<Integer> itr = arr.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("Size: " + arr.size());
        System.out.println("Contains 10? " + arr.contains(10));
        System.out.println("Is empty? " + arr.isEmpty());
        System.out.println("Index of 5 (first occurrence): " + arr.indexOf(5));
        System.out.println("Index of 2 (last occurrence): " + arr.lastIndexOf(2));
        System.out.println("Index of 100 (not in array list): " + arr.indexOf(100));
        System.out.println("Element at index 5: " + arr.get(5));

        System.out.println("Before adding 40 at index 1: " + arr);
        arr.add(1, 40);
        System.out.println(arr);
        System.out.println("Now we will change 40 to 80");
        arr.set(1, 80);
        System.out.println(arr);
        System.out.println("Let's remove 80");
        arr.remove(Integer.valueOf(80));
        System.out.println(arr);
        System.out.println("Let's remove the element at index 1");
        arr.remove(1);
        System.out.println(arr);

        System.out.println("You can assign one ArrayList to another");
        //List<Integer> arr2 = arr; // copy by reference

        List<Integer> arr2 = new ArrayList<>();
        List<Integer> arr3 = new ArrayList<>();
        arr3.add(10);
        arr3.add(20);
        arr3.add(30);
        arr2.addAll(arr); // Copy by value
        arr.add(123);
        arr3.addAll(2, arr); // Specify the starting index for insertion
        System.out.println(arr);
        System.out.println(arr2);
        System.out.println(arr3);

        List<Integer> subList = new ArrayList<>();
        subList = arr3.subList(2, 7); // inclusive-exclusive
        System.out.println(subList);

        System.out.println("To Array");

        Object[] primitiveArr = arr3.toArray();
        for (Object o : primitiveArr) {
            System.out.print(o + " ");
        }

        System.out.println("Or");

        Integer[] intArr = arr3.toArray(new Integer[0]);
        for (Integer i : intArr) {
            System.out.print(i + " ");
        }

    }
}
