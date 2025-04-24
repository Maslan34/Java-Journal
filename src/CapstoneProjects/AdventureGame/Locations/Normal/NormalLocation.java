package CapstoneProjects.AdventureGame.Locations.Normal;

import CapstoneProjects.AdventureGame.Locations.Location;
import CapstoneProjects.AdventureGame.Player;

public class NormalLocation extends Location {

    public NormalLocation(String locationName, Player player, int locationID) {
        super(player,locationName,locationID);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
