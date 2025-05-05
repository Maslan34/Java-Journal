package DesignPatterns.Creational.FactoryMethod.PizzaExample;

public class Pizza {

    String pizzaName;
    String pizzaOrigin;
    String ingredients;

    @Override
    public String toString() {
        return "Pizza{" +
                "pizzaName='" + pizzaName + '\'' +
                ", pizzaOrigin='" + pizzaOrigin + '\'' +
                ", ingredients='" + ingredients + '\'' +
                '}';
    }
}
