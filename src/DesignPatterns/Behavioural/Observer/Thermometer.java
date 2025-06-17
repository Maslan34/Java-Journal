package DesignPatterns.Behavioural.Observer;

public class Thermometer extends Observable {

    private int currentTemperature;
    private int minTemperature;
    private int maxTemperature;

    public Thermometer(int minTemperature, int maxTemperature) {
        this.currentTemperature = 24;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(int currentTemperature) {
        this.currentTemperature = currentTemperature;
        System.out.println("Current Temperature of Thermometer: " + currentTemperature);
        checkTemperature();
    }

    private void checkTemperature() {
        if (currentTemperature > maxTemperature) {
            System.out.println("Temperature is higher than max temperature");
            notifyObservers();
        }
        if (currentTemperature < minTemperature) {
            System.out.println("Temperature is lower than minimum temperature");
            notifyObservers();
        }

    }
}
