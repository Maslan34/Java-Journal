package Practices;

import java.util.*;

public class SubArrayNegative {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();

        String[] arr = sc.nextLine().split(" ");

        int [] integerArr = Arrays.stream(arr)
                .mapToInt(Integer::parseInt).toArray();

        int count =0;
        for(int i=0;i<size;i++){
            int sum =0;
            for(int j =i;j<size;j++){
                sum+=integerArr[j];

                if(sum<0)
                    count++;
            }
        }

        System.out.println(count);
    }
}