package DesignPatterns.Behavioural.Observer;

public class Parent implements Observer {

    String name;

    public Parent(String name) {
        this.name = name;
    }

    @Override
    public void report(Observable observable) {
        Thermometer thermometer = (Thermometer) observable;
        System.out.println("\n"+name+" said that: Thermometer is "+thermometer.getCurrentTemperature()+" degrees!");
    }
}
