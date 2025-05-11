package DesignPatterns.Structural.Adapter.Voltage;

public class Fridge implements HomeAppliance{

    private int volt;

    public Fridge() {
        this.volt = 220;
    }

    @Override
    public int plugAndPlay() {
        System.out.println("Fridge is working");
        return volt;
    }
}
