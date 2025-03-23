package Practices;

public class ArrHarmonicSum {
    public static void main(String[] args) {
        System.out.println("Array -> [1,2,3,4,5,6,7,8,9,10]");
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        float sum = 0.0f;

        for(int i = 0 ;i < arr.length;i++){
            sum += 1.0f/arr[i];
        }
        float harmonicMean = arr.length / sum;
        System.out.println("Harmonik Mean: " + harmonicMean);

    }
}
