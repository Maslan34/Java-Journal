package DesignPatterns.Structural.Bridge.ColorCarExample;

public class T10f implements TOGG{

    private Color color;

    public T10f(Color color) {
        this.color = color;
        createCar();
    }

    @Override
    public void createCar() {
        System.out.println("T10f car created");
        color.drawColor();
    }
}
