package Collections.Sets;

import java.util.HashSet;
import java.util.Iterator;

public class HashSets {

    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(1);

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(2000);
        set.add(null);

        // The output order is not the same, pay attention
        System.out.println(set);
        for (Integer i : set) {
            System.out.println(i);
        }

        System.out.println("Size " + set.size());

        System.out.println("Does it contain 100? = " + set.contains(100));

        System.out.println("Remove 2000 " + set.remove(2000));


        // Collections can also be iterated with an Iterator.

        Iterator<Integer> itr = set.iterator();

       while(itr.hasNext()) {
           System.out.println(itr.next());
       }

    }
}
