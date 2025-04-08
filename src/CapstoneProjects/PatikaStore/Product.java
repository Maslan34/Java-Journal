package CapstoneProjects.PatikaStore;

public abstract class Product {

    private String name;
    private Double price;
    private int stock;
    private Double discountRate;
    private Brand brand;
    private String color;
    private static int counter=1;
    private final int id;



    public Product(String name, Double price, int stock, Double discountRate, Brand brand, String color) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.discountRate = discountRate;
        this.brand = brand;
        this.color = color;
        this.id = counter++;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }


}
