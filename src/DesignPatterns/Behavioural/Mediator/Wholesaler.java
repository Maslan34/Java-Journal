package DesignPatterns.Behavioural.Mediator;

public abstract class Wholesaler {

    private String name;
    private VEGATABLES vegatable;
    private double price;
    private Mediator mediator;

    public Wholesaler(String name, VEGATABLES vegatable, double price, Mediator mediator) {
        this.name = name;
        this.vegatable = vegatable;
        this.price = price;
        this.mediator = mediator;
    }

    public void purchaseVegatables(){
        this.mediator.sellVegatablesToWholesaler(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VEGATABLES getVegatable() {
        return vegatable;
    }

    public void setVegatable(VEGATABLES vegatable) {
        this.vegatable = vegatable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
