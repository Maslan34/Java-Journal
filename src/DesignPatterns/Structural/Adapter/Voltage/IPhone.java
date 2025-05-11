package DesignPatterns.Structural.Adapter.Voltage;

public class IPhone implements Telephone{

    private int workingVoltage;

    public IPhone() {
        this.workingVoltage = 5;
    }

    @Override
    public int charge() {
        System.out.println("IPhone charging ...");
        return workingVoltage;
    }
}
