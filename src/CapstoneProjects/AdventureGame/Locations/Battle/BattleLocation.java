package CapstoneProjects.AdventureGame.Locations.Battle;

import CapstoneProjects.AdventureGame.Locations.Location;
import CapstoneProjects.AdventureGame.Monster.Monster;
import CapstoneProjects.AdventureGame.Player;

import java.util.Random;

public abstract class BattleLocation extends Location {

    private Monster monster;
    private String award;
    private int maxMonster;
    private int remaningMonster;

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

    public int getRemaningMonster() {
        return remaningMonster;
    }

    public void setRemaningMonster(int remaningMonster) {
        this.remaningMonster = remaningMonster;
    }

    public int randomMonster() {
        Random rand = new Random();
        return rand.nextInt(getMaxMonster()) + 1;
    }
    public boolean randomInitiative(){
        Random rand = new Random();
       return rand.nextBoolean();
    }

    @Override
    public boolean onLocation() {
        int monsterNumber = this.randomMonster();
        setRemaningMonster(monsterNumber);

        System.out.println("\nYou are now here " + this.getLocationName());
        System.out.println("Be careful. You may encounter " + monster.getMonsterName() + " here.");
        System.out.println("Oh no! Here " + monsterNumber + " " + monster.getMonsterName() + " here.");
        System.out.println("\nYou have to make a decision now. Will you run away or will you stay and fight?\n1-To Fight\n2-To Run Away\n");
        int selection = input.nextInt();
        while (selection < 1 || selection > 2) {
            System.out.println("Invalid input. Please try again.");
            selection = input.nextInt();
        }
        if (selection == 1) {
            boolean fightResult = fight();
            if (fightResult) {

                System.out.println("\nCongratulations! There is no monster in the " + this.getLocationName() + ".");
                this.getPlayer().getInventory().setFoodObtained();
                System.out.println("You have obtained a very important item.");
                System.out.println(this.getAward() + "!");

                switch (getLocationName()) {
                    case "Cave":
                        this.getPlayer().getInventory().setFoodObtained();
                        break;
                    case "Forest":
                        this.getPlayer().getInventory().setWoodObtained();
                        break;
                    case "River":
                        this.getPlayer().getInventory().setWaterObtained();
                        break;
                }

                return true;
            } else
                return false;
        } else {
            System.out.println("A coward dies a thousand times before his death, but the valiant taste of death but once. - William Shakespeare");
        }

        return true;
    }

    public boolean fight() {

        boolean initiative = this.randomInitiative();
        int currentMonsterNumber = 1;
        while (this.getPlayer().getHealth() > 0 && this.remaningMonster > 0) {
            this.getPlayer().printPlayerStats();

            if(initiative){
                if (playerHit()) {
                    getPlayer().printPlayerStats();
                    currentMonsterNumber++;
                } else {
                    if (monsterHit()) {
                        System.out.println("You Have Died!\nGame is over!");
                        return false;
                    } else {
                        getPlayer().printPlayerStats();
                        monsterStats(currentMonsterNumber);
                    }

                }
            }else{
                if (monsterHit()){
                    monsterStats(currentMonsterNumber);
                } else {
                    if (playerHit()) {
                        getPlayer().printPlayerStats();
                        currentMonsterNumber++;
                    }
                }
            }

            if (remaningMonster != 0) {
                System.out.println("\n1-To Keep Fighting");
                System.out.println("2-To Run Away");
                int selection = input.nextInt();
                while (selection < 1 || selection > 2) {
                    System.out.println("Invalid input. Please try again.");
                    selection = input.nextInt();
                }
                if (selection == 1) {
                } else
                    break;
            }


        }
        return true;
    }


    public boolean playerHit() {
        System.out.println("You Hit the " + this.getMonster().getMonsterName() + " to " + this.getPlayer().getTotalDamage());
        getMonster().setHealth(getMonster().getHealth() - this.getPlayer().getTotalDamage());
        if (getMonster().getHealth() <= 0) {
            System.out.println("You Killed the " + this.getMonster().getMonsterName() + "!");
            System.out.println("You earned " + this.getMonster().getPrize() + " coin!");
            this.getPlayer().setCoin(this.getPlayer().getCoin() + this.getMonster().getPrize());
            remaningMonster--;
            System.out.println("Remaning Monster: " + remaningMonster);
            this.getMonster().setHealth(this.getMonster().getFullHealth());
            return true;
        }
        return false;
    }


    public boolean monsterHit() {
        System.out.println("Monster Hit " + this.getMonster().getDamage() + " to you!");
        int monsterHit = this.getMonster().getDamage();
        if (this.getPlayer().getInventory().getArmor().getBlock() >= monsterHit)
            System.out.println("Your armor has blocked all damage from " + this.getMonster().getMonsterName());
        else
            this.getPlayer().setHealth(this.getPlayer().getHealth() - (this.getMonster().getDamage()- this.getPlayer().getInventory().getArmor().getBlock()) );
        if (this.getPlayer().getHealth() <= 0)
            return true;
        return false;
    }

    public void monsterStats(int currentMonsterNumber) {
        System.out.println("\n"+currentMonsterNumber+".Monster stats: ");
        System.out.println("-------------------------");
        System.out.println("Health: " + getMonster().getHealth());
        System.out.println("Remaming Monster: " + getRemaningMonster());
        System.out.println("Damage: " + getMonster().getDamage());
    }


}
