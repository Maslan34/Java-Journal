package Parallelism;

public class SleepAndStop implements Runnable{

    private String name;

    public SleepAndStop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Thread "+Thread.currentThread().getName()+" Sleeping for 5 seconds in run method");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread "+Thread.currentThread().getName()+" Stopping in run method");
    }
}
