package Practices;

import java.util.Scanner;
public class FindEvens {
    public static void main(String[] args) {

        System.out.println("Please Enter a Number:");
        int number = new Scanner(System.in).nextInt();

        if(number>=0){
            for(int i =0 ;i<=number;i += 2 )
                System.out.println(i);
        }
        else{
            for(int i =0 ;i>=number;i -= 2 )
                System.out.println(i);

        }
    }
}
