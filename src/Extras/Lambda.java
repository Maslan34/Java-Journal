package Extras;

public class Lambda {
    public static void main(String[] args) {
        // Runnable Interface is a Functional Interface. It contains only one abstract method.

        Thread t1 = new Thread(new Runnable() { // Anonymous class
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        });

        t1.start();

        Runnable r1 = () -> System.out.println("Hello World");
        r1.run();


        Mathematics toplama = new Mathematics() {
            @Override
            public int transaction(int a, int b) {
                return a + b;
            }
        };

        Mathematics cikarma = new Mathematics() {
            @Override
            public int transaction(int a, int b) {
                return a - b;
            }
        };

        Mathematics bolme = new Mathematics() {
            @Override
            public int transaction(int a, int b) {
                if (b == 0) {
                    b = 1;
                }
                return a / b;
            }
        };

        Mathematics carpma = new Mathematics() {
            @Override
            public int transaction(int a, int b) {
                return a * b;
            }
        };

        System.out.println(toplama.transaction(10, 2));
        System.out.println(cikarma.transaction(10, 2));
        System.out.println(bolme.transaction(10, 2));
        System.out.println(carpma.transaction(10, 2));

        Mathematics toplamLambda = (a, b) -> a + b;
        Mathematics cikarmaLambda = (a, b) -> a - b;
        Mathematics carpmaLambda = (a, b) -> a * b;
        Mathematics bolmeLambda = (a, b) -> {
            if (b == 0) {
                b = 1;
            }
            return a / b;
        };

        System.out.println(toplamLambda.transaction(10, 2));
        System.out.println(cikarmaLambda.transaction(10, 2));
        System.out.println(carpmaLambda.transaction(10, 2));
        System.out.println(bolmeLambda.transaction(10, 2));

    }
}
