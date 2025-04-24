package CapstoneProjects.AdventureGame.Monster;

public class Monster {
    private int id;
    private int damage;
    private int health;
    private String monsterName;

    public Monster(int id, int damage, int health, String monsterName) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.monsterName = monsterName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }
}
