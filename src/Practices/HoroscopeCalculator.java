package Practices;
import java.util.Scanner;
public class HoroscopeCalculator {
    public static void main(String[] args) {
        int month, day, year;
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter your Birthday: ");
        month = input.nextInt();
        day = input.nextInt();

        for (int i = 1; i <= 2; ++i) {
            for (int j = 1; j < 4; ++j) {
                if (i == 1) continue;
                System.out.print(i + j);
            }
        }
    }
}
