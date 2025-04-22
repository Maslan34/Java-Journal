package CapstoneProjects.AdventureGame;

import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String locationName;
    private int locationID;
    protected static Scanner input = new Scanner(System.in);

    public Location(Player player, String locationName, int locationID) {
        this.player = player;
        this.locationName=locationName;
        this.locationID=locationID;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public abstract boolean  onLocation();
}
