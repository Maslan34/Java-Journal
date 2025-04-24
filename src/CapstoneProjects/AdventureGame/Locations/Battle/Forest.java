package CapstoneProjects.AdventureGame.Locations.Battle;

import CapstoneProjects.AdventureGame.Monster.Vampire;
import CapstoneProjects.AdventureGame.Player;

public class Forest extends BattleLocation {

    public Forest(Player player) {
        super(player, "Forest", 2, new Vampire(), "Wood",3);
    }
}
