package DesignPatterns.Behavioural.Mediator;

public class TomatoFarmer extends Farmer {
    public TomatoFarmer(String name,double price, Mediator mediator) {
        super(name, VEGATABLES.TOMATO, price, mediator);
    }


}
