package DesignPatterns.Creational.FactoryMethod.PizzaExample;

public class Main {
    public static void main(String[] args) {
        HawaiiPizzaStore hawaiiPizzaStore = new  HawaiiPizzaStore();

        hawaiiPizzaStore.orderPizza("cheese");

        ItalyPizzaStore italyPizzaStore = new ItalyPizzaStore();
        Pizza pizza1= italyPizzaStore.orderPizza("margherita");
        Pizza pizza2 = italyPizzaStore.orderPizza("hawaii");

        System.out.println(pizza1);
        System.out.println(pizza2);
    }
}
