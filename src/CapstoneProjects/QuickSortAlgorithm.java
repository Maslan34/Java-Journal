package CapstoneProjects;

import java.util.Arrays;

public class QuickSortAlgorithm {

    public static void main(String[] args) {
        int[] quickSortArray = new int[]{24, 12, 56, 97, 25, 84, 5, 96, 15, 98, 44, 77, 99, 33, 38};

        quickSort(quickSortArray, 0,quickSortArray.length-1);
        System.out.println("Sorted Array: " +
                Arrays.toString(quickSortArray));


    }

    public static void quickSort(int A[], int p, int r) {
        int q;
        if (p < r) {
            q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }

    public static int partition(int A[],int p, int r){
        int tmp;
        int x = A[r];
        int i = p-1;

        for(int j=p; j<=r-1; j++)
        {
            if(A[j]<=x)
            {
                i++;
                tmp=A[i];
                A[i]=A[j];
                A[j]=tmp;
            }
        }
        tmp=A[i+1];
        A[i+1]=A[r];
        A[r]=tmp;
        return i+1;
    }
    
}
