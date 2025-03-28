package Practices;

import java.util.Scanner;

public class BiggestLowestPointer {

    public static void main(String[] args) {
        int[] list = {15,12,788,1,-1,-778,2,0};

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        System.out.println("Please enter a pointer");
        Scanner sc = new Scanner(System.in);
        int pointer = sc.nextInt();

        for (int i : list) {
            if (i >= min && i <= pointer) {
                min = i;
            }
            if (i <= max && i >= pointer) {
                max = i;
            }
        }

        if(min ==Integer.MIN_VALUE)
            System.out.println("The pointer alreadry lowest value");
        else
            System.out.println("The closet mininum value to pointer" + min);
        if(max ==Integer.MAX_VALUE)
            System.out.println("The pointer already biggest value");
        else
            System.out.println("The closet maximum value to pointer " + max);

    }
}
