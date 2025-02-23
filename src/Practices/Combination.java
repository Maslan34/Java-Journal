package Practices;

import java.util.Scanner;
public class Combination {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter a Number:");
        int n =input.nextInt();
        System.out.println("Please Enter a Number:");
        int r = input.nextInt();

        int sumN=1,sumR=1,sumNR=1;

        for(int i = n ; i>=1;i--){
            sumN*=i;
        }
        for(int i = r ; i>=1;i--){
            sumR*=i;
        }
        for(int i = n-r ; i>=1;i--){
            sumNR*=i;
        }

        input.close();
        System.out.println("The Combination is: "+sumN/(sumR*sumNR));


    }
}
