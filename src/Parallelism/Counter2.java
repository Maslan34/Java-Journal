package Parallelism;

public class Counter2 implements Runnable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Counter2(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        for(int i = 0; i < 20; i++) {
            System.out.println(this.name+": "+ i);
        }
     Thread.currentThread().interrupt();
    }
}
