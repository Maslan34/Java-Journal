package DesignPatterns.FactoryMethod.PizzaExample;

public abstract class PizzaStore {

    abstract Pizza createPizza(String item);

    public Pizza orderPizza(String type) {
        Pizza newPizza = createPizza(type);
        System.out.println("Makink your "+type+" pizza");
        return newPizza;
    }
}
