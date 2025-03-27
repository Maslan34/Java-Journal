package Practices;

import java.util.Arrays;
import java.util.Random;

public class RepeatEvens {

    public static void main(String[] args) {

        int[] numbers = new int[20];
        int[] evens= new int[20] ;
        Arrays.fill(evens, -1);
        int j =0;

        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(20);
        }

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 == 0) {
                if(isExist(evens,-1,numbers[i]))
                    continue;
                if (isExist(numbers, i, numbers[i])) {
                    evens[j] = numbers[i];
                    j++;
                }
            }


        }

        evens= Arrays.copyOfRange(evens,0,j);
        System.out.println("Array: "+Arrays.toString(numbers));
        System.out.println("Even numbers: "+Arrays.toString(evens));
    }

    static boolean isExist(int [] arr, int index,int num){
        for( int i = index+1; i <= arr.length-1; i++){
            if(arr[i] == num){
                return true;
            }
        }
        return false;
    }
}
