package DesignPatterns.Behavioural.Template;

public class Coffee extends Beverage {

    @Override
    public void serve() {
        System.out.println("Serve with chocolate.");
    }

    @Override
    public void addIngredients() {
        System.out.println("Sugar and milk added.");
    }
}
