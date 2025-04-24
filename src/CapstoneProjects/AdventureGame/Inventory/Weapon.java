package CapstoneProjects.AdventureGame.Inventory;

public class Weapon {
    private int id;
    private String name;
    private int damage;
    private int price;
    private static Weapon[] weapons = {
            new Weapon(1, "Sword", 2, 2),
            new Weapon(2, "Gun", 3, 4),
            new Weapon(3, "Rifle", 7, 5)
    };

    public Weapon(int id, String name, int damage, int price) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public static Weapon[] getAllWeapons() {
        return weapons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                        "No: " + this.getId()
                        + " | Name: " + this.getName()
                        + " | Damage: " + this.getDamage()
                        + " | Price: " + this.getPrice();
    }
}
