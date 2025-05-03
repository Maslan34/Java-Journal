package DesignPatterns.FactoryMethod.PizzaExample;

public class HawaiiPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        if (type.equals("margherita")) {
            return new PizzaMargherita();
        } else if (type.equals("hawaii"))
            return new PizzaHawaii();
        else return null;
    }
}
