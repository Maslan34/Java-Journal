package Practices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FrequencyOfArray {

    public static void main(String[] args) {
        FrequencyOfArray f = new FrequencyOfArray();
        f.frequencyWithInput();
        f.frequencyWithStatic(List.of(10, 20, 20, 20, 10, 10, 5, 20));
    }

    public void frequencyWithStatic(List<Integer> arr) {

        HashMap<String, Integer> freq = new HashMap<>();

        for (Integer i : arr) {
            if (freq.containsKey(String.valueOf(i))) {
                freq.put(String.valueOf(i), freq.get(String.valueOf(i)) + 1);
            } else {
                freq.put(String.valueOf(i), 1);
            }
        }

        printFrequency(freq);
    }

    public void frequencyWithInput() {
        System.out.println("How many element you want to enter");
        Scanner sc = new Scanner(System.in);
        int element = sc.nextInt();
        int[] arr = new int[element];
        HashMap<String, Integer> freq = new HashMap<>();

        for (int i = 0; i < element; i++) {
            System.out.println("Enter element " + (i + 1) + ": ");
            int input = sc.nextInt();
            sc.nextLine();
            if (freq.containsKey(String.valueOf(input))) {
                freq.put(String.valueOf(input), freq.get(String.valueOf(input)) + 1);
            } else {
                freq.put(String.valueOf(input), 1);
            }

        }

        printFrequency(freq);
        sc.close();

    }

    private void printFrequency(Map<String, Integer> freq) {
        System.out.println("\nThe frequency of array elements:");
        for (var entry : freq.entrySet()) {
            String number = entry.getKey();
            int count = entry.getValue();
            String timesText = (count == 1) ? "time" : "times";
            System.out.println("The number " + number + " appeared " + count + " " + timesText + ".");
        }
    }
}
