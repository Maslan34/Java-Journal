package CapstoneProjects.AdventureGame.Locations.Battle;

import CapstoneProjects.AdventureGame.Monster.Bear;
import CapstoneProjects.AdventureGame.Player;

public class River extends BattleLocation {

    public River(Player player) {
        super(player, "River", 3, new Bear(), "Water",2);
    }
}
