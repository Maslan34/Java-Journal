package Practices;


public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println("Prime Numbers From 1 to 100: ");

        for(int i= 1 ; i <=100;i++){
            boolean isPrime = true;
            if(i==1)
                isPrime = false;
            for(int j= 2;j <i;j++){
                if(i%j==0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
                System.out.println(i+" ");
        }
    }
}
