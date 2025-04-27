package CapstoneProjects.AdventureGame.Inventory;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private boolean isWoodObtained = false;
    private boolean isWaterObtained = false;
    private boolean isFoodObtained = false;


    public Inventory() {
        this.weapon = new Weapon(0, "Fist", 0, 0);
        this.armor = new Armor(0, 0, 0, "Body");
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }


    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void setWoodObtained() {
        isWoodObtained = true;
    }

    public void setWaterObtained() {
        isWaterObtained = true;
    }

    public void setFoodObtained() {
        isFoodObtained = true;
    }

    public boolean isWoodObtained() {
        return isWoodObtained;
    }

    public boolean isWaterObtained() {
        return isWaterObtained;
    }

    public boolean isFoodObtained() {
        return isFoodObtained;
    }
}
