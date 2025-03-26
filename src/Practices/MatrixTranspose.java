package Practices;

import java.util.Scanner;

public class MatrixTranspose {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Getting the number of rows and columns from the user
        System.out.println("Please Define Rows of Matrix:");
        int row = sc.nextInt();
        System.out.println("Please Define Columns of Matrix:");
        int col = sc.nextInt();

        // Initializing the original matrix and its transpose
        int[][] matrix = new int[row][col];
        int[][] transpose = new int[col][row];

        // Taking input elements for the matrix
        int k = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++, k++) {
                System.out.println("Please Enter " + k + "th Element:");
                matrix[i][j] = sc.nextInt();
            }
        }

        // Printing the main matrix
        System.out.println("\n\nMain Matrix:\n");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Calculating the transpose of the matrix
        for (int i = 0; i < matrix.length; i++) { // Looping through rows
            for (int j = 0; j < matrix[i].length; j++) { // Looping through columns
                transpose[j][i] = matrix[i][j]; // Swapping row and column indices
            }
        }

        // Printing the transposed matrix
        System.out.println("\n############################################\n");
        System.out.println("Transpose Matrix:");
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }

        // Closing the scanner to prevent resource leaks
        sc.close();
    }
}
