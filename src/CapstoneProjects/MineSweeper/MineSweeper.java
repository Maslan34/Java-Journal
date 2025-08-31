package CapstoneProjects.MineSweeper;

import java.util.Scanner;
public class MineSweeper {
    public static void main(String[] args) {
        System.out.println("Welcome to MineSweeper");
        startGame();

    }


    static void startGame() {
        int selection,ROWS,COLS;
        Scanner input = new Scanner(System.in);
        System.out.println("1-Start the Game\n2-Quit the Game");
        selection = input.nextInt();

        switch (selection) {
            case 1:
                do {
                    System.out.println("Please enter a number to determine the number of rows of your minefield.");
                    ROWS = input.nextInt();
                    System.out.println("Please enter a number to determine the number of columns of your minefield.");
                    COLS = input.nextInt();

                    if (ROWS < 2 || COLS < 2) {
                        System.out.println("Rows and columns must be greater than 2, please try again.");
                    }

                } while (ROWS < 2 || COLS < 2);

                    Field field = new Field(ROWS, COLS);
                    field.setField();
                    Game game = new Game(field);
                    System.out.println("The game has started with "+field.getBombCount()+" bombs!\n");
                    game.field.printField();
                    game.start();

                    break;
            case 2:
                System.exit(0);
            default:
                System.out.println("Invalid selection. Please enter 1 to start the game or 2 to quit.");
                startGame();
        }
    }


}
