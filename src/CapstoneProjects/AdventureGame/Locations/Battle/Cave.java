package CapstoneProjects.AdventureGame.Locations.Battle;

import CapstoneProjects.AdventureGame.Monster.Zombie;
import CapstoneProjects.AdventureGame.Player;

public class Cave extends BattleLocation {

    public Cave(Player player) {
        super(player, "Cave", 1, new Zombie(), "Food",3);
    }
}
