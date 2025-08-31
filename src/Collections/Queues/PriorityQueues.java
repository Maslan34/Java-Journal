package Collections.Queues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueues {
    public static void main(String[] args) {
        // Comparator gives priority to even numbers
        Comparator<Integer> compareForEven = new Comparator<>() {
            public int compare(Integer i, Integer j) {
                int result = i % 2 - j % 2;
                if (result == 0)
                    result = i - j;
                return result;
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>(20, compareForEven);

        // Add numbers to the queue in reverse order
        for (int i = 0; i < 20; i++) {
            pq.offer(20 - i);
        }
        // Print elements in the order defined by the Comparator
        for (int i = 0; i < 20; i++) {
            System.out.print("\t" + pq.poll());
        }

    }
}

