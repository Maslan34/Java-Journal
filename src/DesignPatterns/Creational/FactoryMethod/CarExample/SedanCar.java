package DesignPatterns.Creational.FactoryMethod.CarExample;

public class SedanCar extends Car {
    @Override
    public void create() {
        System.out.println("Sedan Car Created in Sedan Car Class");
    }
}
