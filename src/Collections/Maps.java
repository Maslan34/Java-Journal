package Collections;

import java.util.HashMap;

public class Maps {
    public static void main(String[] args) {

        // Elements are ordered based on hash, FIFO is not guaranteed, and duplicates are not allowed.

        HashMap<String, String> capitalCities = new HashMap<String, String>();
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        capitalCities.put("England", "London");
        System.out.println(capitalCities);

        capitalCities.get("England");
        //capitalCities.remove("England");
        //capitalCities.clear();
        capitalCities.size();

        for (String i : capitalCities.keySet()) {
            System.out.println(i);
        }

        for (String i : capitalCities.values()) {
            System.out.println(i);
        }

        for (String i : capitalCities.keySet()) {
            System.out.println("key: " + i + " value: " + capitalCities.get(i));
        }
    }
}

