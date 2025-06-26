package DesignPatterns.Behavioural.Template;

public class Tea extends Beverage {

    @Override
    public void serve() {
        System.out.println("Serve with baklava.");
    }

    @Override
    public void addIngredients() {
        System.out.println("Adding buds to tea.");
    }
}
