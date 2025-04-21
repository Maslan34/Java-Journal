package CapstoneProjects.AdventureGame;

import java.util.Scanner;

public class Game {



    public void startGame() {
        System.out.println("Welcome to Adventure Game!");
        System.out.println("Please Enter A Name for your character: ");
        Scanner input = new Scanner(System.in);
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getPlayerName().toUpperCase() + " Welcome to this dark, difficult and foggy island. " +
                "Many adventures await you on this island."
        );

        player.selectCharacter();

    }


}
