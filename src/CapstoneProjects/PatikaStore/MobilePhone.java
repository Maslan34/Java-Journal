package CapstoneProjects.PatikaStore;

public class MobilePhone extends Product{

    private int memory;
    private Double screenSize;
    private int batteryPower;
    public static int counter =0;

    public MobilePhone(String name, Double price, int stock, Double discountRate, Brand brand,String color,int memory,Double screenSize,int batteryPower) {
        super(name,price,stock,discountRate,brand,color);
        this.memory = memory;
        this.screenSize = screenSize;
        this.batteryPower = batteryPower;
        counter++;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public Double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Double screenSize) {
        this.screenSize = screenSize;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }


}
