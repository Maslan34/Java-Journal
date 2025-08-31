package Parallelism;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*

        Threadi extend ile çalıştırma

        Counter counter1 = new Counter("Counter-1");
        Counter counter2 = new Counter("Counter-2");

        counter1.start();
        counter2.start();

         */

        // Threadi Interface Ile çalıştırma

        /*

        Counter2 c1=new Counter2("Counter 1");
        Counter2 c2=new Counter2("Counter 2");
        Counter2 c3=new Counter2("Counter 3");

        Thread t1=new Thread(c1);
        Thread t2=new Thread(c2);
        Thread t3=new Thread(c3);

        t1.start();
        t2.start();
        t3.start();

         */


        /*
        SleepAndStop s1 = new SleepAndStop("Muharrem");
        Thread t4 = new Thread(s1);
        t4.start();

        System.out.println("Sleeping for 3 seconds in main method" );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName());


         */

        RaceConditionCriticalSection raceConditionCritical= new RaceConditionCriticalSection();

        List<Thread> threads= new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(raceConditionCritical);
            threads.add(t);
            t.start();
        }

    }
}
