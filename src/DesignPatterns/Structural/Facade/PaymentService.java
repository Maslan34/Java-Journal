package DesignPatterns.Structural.Facade;

public class PaymentService {
    public boolean pay(String accountId, double amount) {
        System.out.println(amount+" TL was collected from "+accountId+".");
        return true;
    }
}
