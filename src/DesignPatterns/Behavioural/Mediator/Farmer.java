package DesignPatterns.Behavioural.Mediator;

public abstract class Farmer {

    private String name;
    private VEGATABLES vegatable;
    private double price;
    private Mediator mediator;

    public Farmer(String name, VEGATABLES vegatable, double price, Mediator mediator) {
        this.name = name;
        this.vegatable = vegatable;
        this.price = price;
        this.mediator = mediator;
    }

    public void sellVegatables(){
        this.mediator.getVegatablesFromFarmer(this);
    }

    public String getName() {
        return name;
    }

    public VEGATABLES getVegatable() {
        return vegatable;
    }

    public double getPrice() {
        return price;
    }
}
