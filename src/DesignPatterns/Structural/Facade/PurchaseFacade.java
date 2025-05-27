package DesignPatterns.Structural.Facade;

public class PurchaseFacade {

    private StockService stockService = new StockService();
    private PaymentService paymentService = new PaymentService();
    private ShippingService shippingService = new ShippingService();

    public void purchaseProduct(String productId, String accountId, double price) {
        System.out.println("--- Purchase Process ---");

        if (stockService.checkStock(productId)) {
            if (paymentService.pay(accountId, price)) {
                shippingService.shipProduct(productId);
                System.out.println("The purchase was successful.");
            } else {
                System.out.println("Payment failed.");
            }
        } else {
            System.out.println("Product number" + productId + " id is out of stock.");
        }
    }
}
