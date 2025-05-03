package DesignPatterns.FactoryMethod.CarExample;

public class SuvCar extends Car{

    @Override
    public void create() {
        System.out.println("Suv Car Created in Suv Car Class");
    }
}
