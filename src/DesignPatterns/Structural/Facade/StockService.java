package DesignPatterns.Structural.Facade;

public class StockService {
    public boolean checkStock(String productId) {
        System.out.println("Checking Stock For: " + productId);
        return true;
    }
}
