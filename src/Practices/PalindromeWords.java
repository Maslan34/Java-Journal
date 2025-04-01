package Practices;

import java.util.Scanner;

public class PalindromeWords {
    public static void main(String[] args) {
        System.out.println("Please enter a word to check if it is a palindromic word:");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine().toLowerCase().trim();

        char [] arr = word.toCharArray();

        for(int i = arr.length-1,j=0; i >= 0; i--,j++){
            if(arr[j] != arr[i]){
                System.out.println("Not a palindromic word!");
               return;
            }
        }
        System.out.println("It is a palindromic word!");
    }
}
