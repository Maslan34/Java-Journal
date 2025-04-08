package CapstoneProjects.PatikaStore;

public class Notebook extends Product{


    private int ram;
    private int storage;
    private float screeSize;
    public static int counter = 0;

    public Notebook(String name, Double price, int stock, Double discountRate, Brand brand, String color, int ram, int storage, float screeSize) {
        super(name, price, stock, discountRate, brand, color);
        this.ram = ram;
        this.storage = storage;
        this.screeSize = screeSize;
        counter++;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }


    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public float getScreeSize() {
        return screeSize;
    }

    public void setScreeSize(float screeSize) {
        this.screeSize = screeSize;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                ", ram=" + ram +
                ", storage=" + storage +
                ", screeSize=" + screeSize +
                '}';
    }
}
