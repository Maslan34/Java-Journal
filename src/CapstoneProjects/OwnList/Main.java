package CapstoneProjects.OwnList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*
    OwnList<Integer> list = new OwnList<>();
    System.out.println("Number of elements in the array: " + list.size());
    System.out.println("Capacity of the array: " + list.getCapacity());
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    System.out.println("Number of elements in the array: " + list.size());
    System.out.println("Capacity of the array: " + list.getCapacity());
    list.add(50);
    list.add(60);
    list.add(70);
    list.add(80);
    list.add(90);
    list.add(100);
    list.add(110);
    System.out.println("Number of elements in the array: " + list.size());
    System.out.println("Array Capacity: " + list.getCapacity());

    System.out.println("Array: " + list);

    OwnList<Integer> list2 = new OwnList<>();
    System.out.println(list2.isEmpty());
*/

/*
    OwnList<Integer> list = new OwnList<>();
    System.out.println("List Status: " + (list.isEmpty() ? "Empty" : "Full"));
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(20);
    list.add(50);
    list.add(60);
    list.add(70);

    System.out.println("List Status: " + (list.isEmpty() ? "Empty" : "Full"));

    // Returns the first index it finds
    System.out.println("Index: " + list.indexOf(20));

    // Returns -1 if not found
    System.out.println("Index: " + list.indexOf(100));

    // Returns the last index it finds
    //System.out.println("Index: " + list.lastIndexOf(20));

    // Returns the list as an Object[] array
    Object[] array = list.toArray();
    System.out.println("First element of Object array: " + array[0]);

    // Creates a sublist of the current list
    //OwnList<Integer> subList = list.subList(0, 3);
    //System.out.println(subList.toString());

    // Checks if value exists in the list
    System.out.println("Does my list contain value 20: " + list.contains(20));
    System.out.println("Does my list contain value 120: " + list.contains(120));

    // Clears the list and resets capacity to default
    list.clear();
    System.out.println(list.toString());
*/

/*
    OwnList<String> list = new OwnList<>(5);
    list.add("Java");  // ERROR: NullPointerException
*/

/*
    OwnList<String> list = new OwnList<>(3);
    list.add("A");
    list.add("B");
    list.add("C");  // No capacity increase, list is full
    list.add("D");  // ERROR: ArrayIndexOutOfBoundsException
*/

/*
    OwnList<String> list = new OwnList<>();
    list.add("A");
    list.add("B");
    list.remove(0);
    System.out.println(list.getSize());  // Outputs 2, but only 1 element remains
    System.out.println(list.toString());
*/

/*
    OwnList<Integer> list = new OwnList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.remove(2);
    list.toString();
    // System.out.println(list.get(4));  5 exists, but it's logically removed so may return null;
*/

/*
    OwnList<String> list = new OwnList<>();
    System.out.println(list.toString());
*/


        OwnList<Integer> list = new OwnList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);

        Object[] arr = list.toArray();
        System.out.println(Arrays.toString(arr));


    }
}
