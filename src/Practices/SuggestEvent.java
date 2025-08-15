package Practices;

import java.util.Scanner;
public class SuggestEvent {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter Weather Temperature: ");
        int temperature = input.nextInt();

        boolean isHot = temperature>=25;
        boolean isCold = temperature<=5;
        boolean isWarm = temperature>=15 && temperature<25;

        String suggestion = isHot?"You should go for a swimming":
                isCold?"You should go for a ski":
                        isWarm? "You should go for a picnic":
                                "You should go for a cinema";
        System.out.println(suggestion);

        input.close();
    }
}
