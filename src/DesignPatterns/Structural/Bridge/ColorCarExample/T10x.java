package DesignPatterns.Structural.Bridge.ColorCarExample;

public class T10x implements TOGG{

    private Color color;

    public T10x(Color color) {
        this.color = color;
        createCar();
    }

    @Override
    public void createCar() {
        System.out.println("T10x car created");
        color.drawColor();
    }
}
