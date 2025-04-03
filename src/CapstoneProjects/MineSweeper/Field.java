package CapstoneProjects.MineSweeper;

public class Field {
    int Field[][];
    String Screen[][];
    int rows;
    int cols;
    int bombCount;
    int fieldWidth;


    Field(int row, int col) {
        this.rows = row;
        this.cols = col;
        this.fieldWidth = (row * col);
        Field = new int[rows][cols];
        Screen = new String[rows][cols];

        bombCount = (col * row) / 4;
    }

    public int getFieldWidth() {
        return fieldWidth;
    }

    public int getBombCount() {
        return bombCount;
    }


    void printField() {
        System.out.println("The final state of the field");
        System.out.println();
        for (String[] r : Screen) {
            for (String c : r) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void setField() {

        for (int i = 0; i < this.Field.length; i++) {
            for (int j = 0; j < this.Field[i].length; j++) {
                this.Field[i][j] = 0;
            }
        }

        for (int count = 0; count < bombCount; count++) {
            int randomCordinateX;
            int randomCordinateY;

            while (true) {
                randomCordinateX = (int) (Math.random() * this.rows);
                randomCordinateY = (int) (Math.random() * this.cols);
                if (this.Field[randomCordinateX][randomCordinateY] != 1) {
                    this.Field[randomCordinateX][randomCordinateY] = 1;
                    break;
                }

            }
            //System.out.println("Created X" + randomCordinateX + " Y" + randomCordinateY);
        }

        // Debug
        for (int i = 0; i < this.Field.length; i++) {
            for (int j = 0; j < this.Field[i].length; j++) {
                System.out.print(this.Field[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < this.Screen.length; i++) {
            for (int j = 0; j < this.Screen[i].length; j++) {
                this.Screen[i][j] = "_";
            }
        }

    }

    public void updateSituation(int x, int y) {
        int counter = 0;
        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1}, //  Top
                {0, -1}, {0, 1},    // Middle
                {1, -1}, {1, 0}, {1, 1}     // Bottom
        };

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            // Border Control
            if (newX >= 0 && newX < Field.length && newY >= 0 && newY < Field[0].length) {
                if (Field[newX][newY] == 1)
                    counter++;
            }

        }
        this.update(x, y, counter);
    }

    public void update(int x, int y, int counter) {
        this.Screen[x][y] = String.valueOf(counter);
        this.printField();
    }
}
