package CapstoneProjects.AdventureGame.Locations.Normal;

import CapstoneProjects.AdventureGame.Player;

public class SafeHouse extends NormalLocation {
    public SafeHouse(Player player) {
        super("Safe House", player,1);
    }

    @Override
    public boolean onLocation() {
        System.out.println("\nYou are now Safe House!");
        boolean isGAmeFinished =getPlayer().getInventory().isFoodObtained() &&
                getPlayer().getInventory().isWoodObtained() &&
                getPlayer().getInventory().isWaterObtained();

        if(isGAmeFinished)
        {
            System.out.println("Congratulations! \uD83C\uDF8A \nYou managed to escape from the island by collecting all the necessary items.");

            System.exit(0);
        }else{
            System.out.println("Your health has been restored.");
            System.out.println("\nThe Awards You Have Gained:");

            System.out.println(getPlayer().getInventory().isFoodObtained() ? "Food: --> \u2705" : "Food: --> \u274C");
            System.out.println(getPlayer().getInventory().isWoodObtained() ? "Wood: -->\u2705" : "Wood: --> \u274C");
            System.out.println(getPlayer().getInventory().isWaterObtained() ? "Water: --> \u2705" : "Water: --> \u274C");
            getPlayer().setHealth(getPlayer().getFullHealth());
            System.out.println();

            getPlayer().printPlayerStats();
        }

        return true;
    }
}
