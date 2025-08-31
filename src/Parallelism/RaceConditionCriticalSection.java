package Parallelism;

public class RaceConditionCriticalSection implements Runnable {

    private int orderNo;
    private final Object lock = new Object();

    public RaceConditionCriticalSection() {
        this.orderNo = 0;
    }
    @Override
    public void run() {
        // a little bit delay to see race condition!
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Critical section for all threads!
        /*

         */


        /*
        synchronized (lock) {
            this.orderNo = this.orderNo + 1;
        }

         */

        /*
            increaseOrder();
         */
        this.orderNo = this.orderNo + 1;

        System.out.println(Thread.currentThread().getName() + " orderNo: " + this.orderNo);
    }

    public synchronized void   increseOrder(){
        this.orderNo++;
    }
}
