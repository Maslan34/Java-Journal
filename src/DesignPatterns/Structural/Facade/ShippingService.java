package DesignPatterns.Structural.Facade;

public class ShippingService {
    public void shipProduct(String productId) {
        System.out.println(productId+" the product has been shipped.");
    }
}
