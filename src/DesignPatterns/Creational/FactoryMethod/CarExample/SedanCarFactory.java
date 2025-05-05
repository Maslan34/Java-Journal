package DesignPatterns.Creational.FactoryMethod.CarExample;

public class SedanCarFactory extends CarFactory {
    public Car createCar() {
        return new SedanCar();
    }
}
