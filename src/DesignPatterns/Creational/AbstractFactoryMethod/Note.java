package DesignPatterns.Creational.AbstractFactoryMethod;

public class Note implements Telephone{

    String model;
    int width;
    int height;

    public Note(String model, int width, int height) {
        this.model = model;
        this.width = width;
        this.height = height;
    }

    @Override
    public void call() {
        System.out.println("A Note telephone is calling.");
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
