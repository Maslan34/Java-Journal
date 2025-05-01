package CapstoneProjects.AdventureGame.Inventory;

public class Armor {
    private int id;
    private int block;
    private int price;
    private String name;
    private static Armor[] armors = {
            new Armor(1, 1, 20, "Slight"),
            new Armor(2, 3, 30, "Medium"),
            new Armor(3, 5, 50, "Heavy"),
    };


    public Armor(int id, int block, int price, String name) {
        this.id = id;
        this.block = block;
        this.price = price;
        this.name = name;
    }

    public static Armor[] getAllArmors(){
        return armors;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                        "No: " + this.getId()
                        + " | Name: " + this.getName()
                        + " | Block: " + this.getBlock()
                        + " | Price: " + this.getPrice();
    }
}
