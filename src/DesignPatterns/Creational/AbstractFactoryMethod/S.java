package DesignPatterns.Creational.AbstractFactoryMethod;

public class S implements Telephone{

    String model;
    int width;
    int height;


    public S(String model, int width, int height) {
        this.model = model;
        this.width = width;
        this.height = height;
    }

    @Override
    public void call() {
        System.out.println("A S telephone is calling.");
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
