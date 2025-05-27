package DesignPatterns.Structural.Facade;

public class BadExample {
    public static void main(String[] args) {
        System.out.println("--- Purchase Process ---");


        StockService stockService = new StockService();
        PaymentService paymentService = new PaymentService();
        ShippingService shippingService = new ShippingService();

        String productId = "IST34";
        String accountId = "USER_34";
        double price = 2499.99;


        if (stockService.checkStock(productId)) {
            if (paymentService.pay(accountId, price)) {
                shippingService.shipProduct(productId);
                System.out.println("The purchase was successful.");
            } else {
                System.out.println("Payment Failed");
            }
        } else {
            System.out.println("Product number" + productId + " id is out of stock.");
        }


    }
}
