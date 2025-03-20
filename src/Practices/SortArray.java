package Practices;

import java.util.Scanner;
public class SortArray {
    public static void main(String[] args) {
        System.out.println("Enter the size of the array: ");
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the "+(i+1)+"th element: ");
            array[i] = input.nextInt();
        }

        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("The sorted array is: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }

        input.close();

    }
}
