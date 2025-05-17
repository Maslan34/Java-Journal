package DesignPatterns.Structural.Composite;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String basketName;
    private List<Priceable> cart;


    public Cart(String basketName) {
        this.basketName = basketName;
        this.cart = new ArrayList<>();
    }

    public int getCartTotalPrice() {
        int totalPrice = 0;
        for (Priceable priceable : cart) {
            totalPrice += priceable.getPrice();
        }
        return totalPrice;
    }

    public String getBasketName() {
        return basketName;
    }

    public void setBasketName(String basketName) {
        this.basketName = basketName;
    }

    public List<Priceable> getCart() {
        return cart;
    }

    public void setCart(List<Priceable> cart) {
        this.cart = cart;
    }
}
