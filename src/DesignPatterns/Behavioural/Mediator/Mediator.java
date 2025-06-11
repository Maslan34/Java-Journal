package DesignPatterns.Behavioural.Mediator;

public interface Mediator {

    void addWholesaler(Wholesaler wholesaler);
    void addFarmer(Farmer farmer);
    void getVegatablesFromFarmer(Farmer farmer);
    void sellVegatablesToWholesaler(Wholesaler wholesaler);
}
