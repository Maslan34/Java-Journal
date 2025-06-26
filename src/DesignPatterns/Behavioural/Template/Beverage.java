package DesignPatterns.Behavioural.Template;

public abstract class Beverage {

    // Template method:Final olarak tanımlanır çünkü değiştirilmesi istenmez.Böylelikle bir taslak oluşturulmuş olur.
    public final void prepareBeverage() {
        heatWater();
        addIngredients();
        pourIntoCup();
        serve();
    }

    // Her içecek için ortak olan fonksiyonlar.
    public void heatWater() {
        System.out.println("Water is being heated.");
    }

    public void pourIntoCup() {
        System.out.println("It is being poured into the cup.");
    }

    //Bu fonksiyonlar alt sınıflarda özelleştirilecek fonksiyonlar
    public abstract void serve();
    public abstract void addIngredients ();
}

