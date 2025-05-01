package CapstoneProjects.AdventureGame;

import CapstoneProjects.AdventureGame.Inventory.Inventory;
import CapstoneProjects.AdventureGame.Locations.Battle.Cave;
import CapstoneProjects.AdventureGame.Locations.Battle.Forest;
import CapstoneProjects.AdventureGame.Locations.Battle.Mine;
import CapstoneProjects.AdventureGame.Locations.Battle.River;
import CapstoneProjects.AdventureGame.Locations.Location;
import CapstoneProjects.AdventureGame.Locations.Normal.InventoryStore;
import CapstoneProjects.AdventureGame.Locations.Normal.SafeHouse;

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
        while (true) {

            boolean isValid = false;

            System.out.println("\nLocations: \n1-Safe House --> This is a safe house for you. There are no monsters here and you can regenerate your health here." +
                    "\n2-Inventory Store --> You can purchase Weapons or Armor.\n3-Cave --> Reward<Food> Enter Cave\n4-Forest --> Reward<Wood> Enter Forest" +
                    "\n5-River --> Reward<Water> Enter River\n6-Mine --> You can earn new things such as Weapon, Armor, Coin here.");

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
                        case 3:
                            if (player.getInventory().isFoodObtained()) {
                                System.out.println("\nYou have already obtained Food !\nYou do not need to enter here!\n");
                                break;
                            }

                            loc = new Cave(player);
                            isValid = true;
                            break;
                        case 4:
                            if (player.getInventory().isWoodObtained()) {
                                System.out.println("\nYou have already obtained Wood !\nYou do not need to enter here!\n");
                                break;
                            }
                            loc = new Forest(player);
                            isValid = true;
                            break;
                        case 5:
                            if (player.getInventory().isWaterObtained()) {
                                System.out.println("\nYou have already obtained Water !\nYou do not need to enter here!\n");
                                break;
                            }
                            loc = new River(player);
                            isValid = true;
                            break;
                        case 6:
                            loc = new Mine(player);
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

            if (!loc.onLocation()) {
                System.out.println("You Died! Game is Over!");
                break;
            }

        }

    }


}
