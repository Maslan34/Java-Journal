package DesignPatterns.Structural.Facade;


// Structural
// Facade : Karmaşık alt sistemlerin kullanımını basitleştirmek için kullanılan bir yapısal tasarım desenidir.
// BadExample ile bu örnek karşılaştırıldığında gerekli servisler ihtiyac olunan heryerde initialize edilmeli ve
// gerekli işlemleri yapılmalı. Burada bu işlemler için bir facade sınıfı tasarlanarak basit şekilde kullanılır.
// Interface kullanılarak soyutlanabilirdide ama burada gerek görülmedi.

public class Main {
    public static void main(String[] args) {
        PurchaseFacade purchase = new PurchaseFacade();
        purchase.purchaseProduct("IST34", "USER_34", 2499.99);
    }
}
