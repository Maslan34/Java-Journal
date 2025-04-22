package CapstoneProjects.AdventureGame;

import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int coin;
    private Inventory inventory;
    private String playerName;

    private static Scanner input = new Scanner(System.in);

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void selectCharacter() {
        GameCharacter[] characters = {new Samurai(), new Archer(), new Knight(),};
        System.out.println("Please select a character: \n");
        System.out.printf("%-4s| %-12s| %-7s| %-7s| %-5s%n", "No", "Character", "Damage", "Health", "Coin");
        System.out.println("----|-------------|--------|--------|------");
        for (int i = 0; i < characters.length; i++) {
            System.out.printf("%-4d| %-12s| %-7d| %-7d| %-5d%n", characters[i].getId(),
                    characters[i].getCharacterName(),
                    characters[i].getDamage(),
                    characters[i].getHealth(),
                    characters[i].getCoin());
        }
        System.out.println("\n");
        boolean isValid = false;
        while (!isValid) {
            System.out.print("\nYour selection: ");
            if (input.hasNextInt()) {
                int selection = input.nextInt();
                if (selection >= 1 && selection <= characters.length) {
                    initPlayer(characters[selection - 1]);
                    isValid = true;
                } else {
                    System.out.println("Invalid selection. Please enter a number between 1 and " + characters.length + ".");
                }
            } else {
                System.out.println("Please enter a valid number.");
                input.next();
            }
        }

    }

    public void initPlayer(GameCharacter gameCharacter) {
        setDamage(gameCharacter.getDamage());
        setHealth(gameCharacter.getHealth());
        setCoin(gameCharacter.getCoin());
        System.out.println("\n\nCharacter: ");
        System.out.printf("%-15s| %-5s| %-5s| %-5s%n", "Player Name", "Damage", "Health", "Coin");
        System.out.println("---------------------------------------");

        System.out.printf("%-15s| %-5d| %-5d| %-5d|", this.getPlayerName(),
                this.getDamage(),
                this.getHealth(),
                this.getCoin());
    }

}
