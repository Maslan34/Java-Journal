package CapstoneProjects.AdventureGame.Locations.Battle;

import CapstoneProjects.AdventureGame.Locations.Location;
import CapstoneProjects.AdventureGame.Monster.Monster;
import CapstoneProjects.AdventureGame.Player;

import java.util.Random;

public abstract class BattleLocation extends Location {

    private Monster monster;
    private String award;
    private int maxMonster;

    public BattleLocation(Player player, String locationName, int locationID, Monster monster, String award, int maxMonster) {
        super(player, locationName, locationID);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public int randomMonster() {
        Random rand = new Random();
        return rand.nextInt(getMaxMonster())+1;
    }

    @Override
    public boolean onLocation() {
        int monsterNumber = this.randomMonster();

        System.out.println("\nYou are now here "+this.getLocationName());
        System.out.println("Be careful. You may encounter "+monster.getMonsterName()+" here.");
        System.out.println("Oh no! Here "+monsterNumber+ " "+monster.getMonsterName()+" here.");
        System.out.println("\nYou have to make a decision now. Will you run away or will you stay and fight?\n1-To Fight\n2-To Run Away\n");
        int selection = input.nextInt();
        while (selection <1  || selection >2) {
            System.out.println("Invalid input. Please try again.");
            selection = input.nextInt();
        }
        if(selection == 1){
            System.out.println("Fight");
        }else{
            System.out.println("A coward dies a thousand times before his death, but the valiant taste of death but once. - William Shakespeare");
        }

        return true;
    }
}
