package Collections.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class QueueLinkedList {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        // Adding elements to the queue using the add() method
        // Throws an exception if the element cannot be added
        queue.add("Deniz");
        queue.add("Berna");

        // Adding elements to the queue using the offer() method
        // Returns false if the element cannot be added
        queue.offer("Volkan");
        queue.offer("Çağlar");

        // The remove() method retrieves and removes the head of the queue
        // Throws java.util.NoSuchElementException if the queue is empty
        System.out.println("remove() : " + queue.remove());

        // The element() method retrieves but does not remove the head of the queue
        // Throws java.util.NoSuchElementException if the queue is empty
        // System.out.println("element() : " + queue.element());

        // The poll() method retrieves and removes the head of the queue
        // Returns null if the queue is empty
        System.out.println("poll() : " + queue.poll());

        // The peek() method retrieves but does not remove the head of the queue
        // Returns null if the queue is empty
        System.out.println("peek() : " + queue.peek());

    }
}

