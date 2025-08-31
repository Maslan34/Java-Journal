package CapstoneProjects.MineSweeper;

import java.util.Scanner;

public class Game {
    Field field;
    static int quessCount = 0;

    Game(Field field) {
        this.field = field;
    }

    void start() {
        System.out.println("Please enter the coordinates of the field ");
        int[] coordinates;
        do {
            coordinates = getCoordinates();
            quessCount++;

        } while (!(isGameOver(coordinates)));

    }

    boolean isGameOver(int[] coordinates) {
        if (field.Field[coordinates[0]][coordinates[1]] == 1) {
            System.out.println("Sorry you find the bomb!");
            System.out.println("The Game is over!");
            field.printField();
            return true;
        }
        field.updateSituation(coordinates[0], coordinates[1]);
        if (field.getFieldWidth() == Game.quessCount + field.bombCount) {
            System.out.println("You Win!");
            System.out.println("The Game is over!");
            field.printField();
            return true;
        }
        return false;
    }


    int[] getCoordinates() {
        int x, y;
        Scanner input = new Scanner(System.in);
        do {

            System.out.println("Please enter valid row ");
            x = input.nextInt();
            System.out.println("Please enter valid column ");
            y = input.nextInt();

        } while ((x < 0 || y < 0) || (field.rows < x || field.cols < y)); // Invalid Input Check
        return new int[]{x, y};
    }
}
