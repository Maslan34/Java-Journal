package DesignPatterns.Structural.Adapter.Voltage;

public class Iron implements HomeAppliance{

    private int volt;

    public Iron() {
        this.volt = 220;
    }

    @Override
    public int plugAndPlay() {
        System.out.println("Iron is working");
        return volt;
    }
}
