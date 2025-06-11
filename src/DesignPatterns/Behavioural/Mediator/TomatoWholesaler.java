package DesignPatterns.Behavioural.Mediator;

public class TomatoWholesaler extends Wholesaler {
    public TomatoWholesaler(String name, double price, Mediator mediator) {
        super(name, VEGATABLES.TOMATO, price, mediator);
    }
}
