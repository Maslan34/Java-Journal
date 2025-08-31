package Practices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RaceOfThreads implements Runnable {
    public List<Integer> evens = new ArrayList<>();
    public List<Integer> odds = new ArrayList<>();
    public List<Integer> numbers;

    public RaceOfThreads() {
        this.numbers = IntStream.rangeClosed(1, 100).boxed().toList();
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        int start = 0, end = 0;
        if (threadName.equals("Thread-0")) {
            start = 1; end = 25;
        } else if (threadName.equals("Thread-1")) {
            start = 26; end = 50;
        } else if (threadName.equals("Thread-2")) {
            start = 51; end = 75;
        } else if (threadName.equals("Thread-3")) {
            start = 76; end = 100;
        }

        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                evens.add(i);
            } else {
                odds.add(i);
            }
        }
    }

    public static void main(String[] args) {
        RaceOfThreads race = new RaceOfThreads();

        Thread t1 = new Thread(race);
        Thread t2 = new Thread(race);
        Thread t3 = new Thread(race);
        Thread t4 = new Thread(race);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Even Numbers: " + race.evens);
        System.out.println("Odd Numbers: " + race.odds);
    }
}
