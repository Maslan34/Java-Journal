package CapstoneProjects.AdventureGame.Locations.Battle;

import CapstoneProjects.AdventureGame.Inventory.Armor;
import CapstoneProjects.AdventureGame.Inventory.Weapon;
import CapstoneProjects.AdventureGame.Monster.Snake;
import CapstoneProjects.AdventureGame.Player;

import java.util.Random;

public class Mine extends BattleLocation {

    private final static Random rand = new Random();

    public Mine(Player player) {
        super(player, "Mine", 4, new Snake(), "", 5);
    }

    @Override
    public boolean onLocation() {
        // init Snake damage
        getMonster().setDamage(rand.nextInt(3) + 4);

        int monsterNumber =rand.nextInt(3)+3; // bounds ->  3 between 5
        setRemaningMonster(monsterNumber);

        System.out.println("\nYou are now here " + this.getLocationName());
        System.out.println("Be careful. You may encounter  Snake here.");
        System.out.println("Oh no! Here " + monsterNumber + " Snake here.");
        System.out.println("\nYou have to make a decision now. Will you run away or will you stay and fight?\n1-To Fight\n2-To Run Away\n");
        int selection = input.nextInt();
        while (selection < 1 || selection > 2) {
            System.out.println("Invalid input. Please try again.");
            selection = input.nextInt();
        }
        if (selection == 1) {
            boolean fightResult = fight();
            if (fightResult) {

                // 0 -> Weapon
                int awardPoolRate = rand.nextInt(100);
                int awardRate = -1;  // 0 -> Weapon  1-> Weapon  2-> Coin 3-> Nothing
                int qualityPoolRate = rand.nextInt(100);
                int qualityRate = -1; // 0 Low // 1 Mid //  2 High


                if (qualityPoolRate < 20)
                    qualityRate = 0;
                else if (qualityPoolRate < 50)
                    qualityRate = 1;
                else
                    qualityRate = 2;

                if (awardPoolRate < 15) {
                    awardRate = 0;
                } else if (awardPoolRate < 30)
                    awardRate = 1;
                else if (awardPoolRate < 55)
                    awardRate = 2;
                else
                    awardRate = 3;



                switch (awardRate) {
                    case 0:
                        Weapon weapon=null;
                        switch (qualityRate) {
                            case 0:
                                System.out.println("Congratulations! You have won a Sword weapon.");
                                weapon = Weapon.getAllWeapons()[0];
                                break;
                            case 1:
                                System.out.println("Congratulations! You have won a Gun weapon.");
                                weapon = Weapon.getAllWeapons()[1];
                                break;
                            case 2:
                                System.out.println("Congratulations! You have won a Rifle weapon.");
                                weapon = Weapon.getAllWeapons()[2];
                                break;

                        }
                        if(getPlayer().getInventory().getWeapon().getId()>= weapon.getId())
                            System.out.println("But you have equivalent or better weapon!");
                        else
                            getPlayer().getInventory().setWeapon(weapon);
                        break;
                    case 1:

                        Armor armor=null;
                        switch (qualityRate) {
                            case 0:
                                System.out.println("Congratulations! You have won a light armor.");
                               armor=Armor.getAllArmors()[0];
                                break;
                            case 1:
                                System.out.println("Congratulations! You have won a middle armor.");
                                armor=Armor.getAllArmors()[1];
                                break;
                            case 2:
                                System.out.println("Congratulations! You have won a heavy armor.");
                                armor=Armor.getAllArmors()[2];
                                break;
                        }
                        if(getPlayer().getInventory().getArmor().getId()>= armor.getId())
                            System.out.println("But you have equivalent or better armor!");
                        else
                            getPlayer().getInventory().setArmor(armor);
                        break;
                    case 2:
                        int currentCoin = getPlayer().getCoin();
                        switch (qualityRate) {

                            case 0:
                                System.out.println("You have won 1 coins!");
                                currentCoin++;

                                break;
                            case 1:
                                System.out.println("You have won 5 coins!");
                                currentCoin = currentCoin + 5;

                                break;
                            case 2:
                                System.out.println("You have won 10 coins!");
                                currentCoin = currentCoin + 10;
                                break;
                        }
                        getPlayer().setCoin(currentCoin);
                        break;
                    case 3:
                        System.out.println("You did not find anything here!. Next Time :)");
                        break;
                }
                return true;
            }
        } else {
            System.out.println("A coward dies a thousand times before his death, but the valiant taste of death but once. - William Shakespeare");
        }
        return true;
    }
}
