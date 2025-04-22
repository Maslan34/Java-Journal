package CapstoneProjects.AdventureGame;

public class SafeHouse extends NormalLocation {
    public SafeHouse(Player player) {
        super("Safe House", player,1);
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are now Safe House!");
        System.out.println("Your health has been restored.");
        getPlayer().setHealth(getPlayer().getHealth()-5);
        return true;
    }
}
