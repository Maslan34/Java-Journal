package DesignPatterns.Creational.FactoryMethod.CarExample;

public class SuvCarFactory extends CarFactory{
    public Car createCar() {
        return new SuvCar();
    }
}
