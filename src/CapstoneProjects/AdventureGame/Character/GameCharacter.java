package CapstoneProjects.AdventureGame.Character;

public abstract  class GameCharacter {
    private int id;
    private String characterName;
    private int damage;
    private int health;
    private int coin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GameCharacter(int id, String characterName, int damage, int health, int coin) {
        this.id=id;
        this.characterName = characterName;
        this.damage = damage;
        this.health = health;
        this.coin = coin;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
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

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }



}
