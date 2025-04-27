package CapstoneProjects.AdventureGame.Locations.Normal;

import CapstoneProjects.AdventureGame.Player;

public class SafeHouse extends NormalLocation {
    public SafeHouse(Player player) {
        super("Safe House", player,1);
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are now Safe House!");
        System.out.println("Your health has been restored.");
        System.out.println("The Awards You Have Gained:");
        System.out.println(getPlayer().getInventory().isFoodObtained() ? "Food: --> \u2705" : "Food: --> \u274C");
        System.out.println(getPlayer().getInventory().isWoodObtained() ? "Wood: -->\u2705" : "Wood: --> \u274C");
        System.out.println(getPlayer().getInventory().isWaterObtained() ? "Water: --> \u2705" : "Water: --> \u274C");
        getPlayer().setHealth(getPlayer().getFullHealth());
        return true;
    }
}
