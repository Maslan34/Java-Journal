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
        Inventory inventory = new Inventory();
        player.setInventory(inventory);
        Location loc = null;
        while(true) {

            boolean isValid = false;

            System.out.println("\nLocations: \n1-Safe House\n2-Inventory Store");

            while (!isValid) {
                System.out.print("Please select a location you want to go: ");

                if (input.hasNextInt()) {
                    int location = input.nextInt();
                    switch (location) {
                        case 1:
                            loc = new SafeHouse(player);
                            isValid = true;
                            break;
                        case 2:
                            loc = new InventoryStore(player);
                            isValid = true;
                            break;
                        default:
                            System.out.println("Invalid selection. Please enter a valid number.");
                            break;
                    }
                } else {
                    System.out.println("Please enter a valid number.");
                    input.next();
                }
            }

            if(!loc.onLocation()){
                System.out.println("You Died! Game is Over!");
                break;
            }

        }

    }


}
