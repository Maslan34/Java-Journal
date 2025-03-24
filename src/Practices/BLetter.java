package Practices;


public class BLetter {
    public static void main(String[] args) {


        String[][] bLetter = new String[10][10];

        for (int i = 0; i < bLetter.length; i++) {

            for (int j = 0; j < bLetter[i].length; j++) {
                // Clearing Nulls
                bLetter[i][j] = " ";

                // Left Corner
                bLetter[i][0] = "*";

                // Top Corner
                if (i == 0 && j < 8)
                    bLetter[i][j] = "*";
                //Middle
                if (i == 4 && j < 4)
                    bLetter[i][j] = "*";

                // Bottom Corner
                if (i == bLetter.length - 1 && j < 8)
                    bLetter[i][j] = "*";

                if (j == 7 && (i == 1 || i == 8))
                    bLetter[i][j] = "*";

                // Line from top to middle
                if ((i + j) == 7 && j >= i)
                    bLetter[i][j] = "*";
                // Line from bottom to middle
                if ((i - j == 2) && i > 4)
                    bLetter[i][j] = "*";

            }

        }


        for (int i = 0; i < bLetter.length; i++) {
            for (int j = 0; j < bLetter[i].length; j++)
                System.out.print(bLetter[i][j] + " ");
            System.out.println();

        }


        System.out.println();


    }
}
