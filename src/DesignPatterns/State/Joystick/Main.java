package DesignPatterns.State.Joystick;

// Behavioural
// State :Bir nesnenin iç durumuna göre davranışını değiştirmesini sağlar.
// Yani bir nesne, farklı durumlarda farklı şekillerde davranabilir.
// Bu desen, durum geçişlerinin yönetilmesini ve kodun daha esnek ve okunabilir olmasını sağlar.

//Avantajları:

//if-else ya da switch-case bloklarından kurtarır.

//Kod daha modüler, bakımı kolay ve açık/kapalı ilkesine uygun olur.

// Dezavantajları:

//Durum sayısı fazla ise, çok sayıda sınıf oluşur (class patlaması yaşanabilir).


public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.triggerCircle();
        game.triggerTriangle();
        game.triggerSquare();
        System.out.println("The ball went out.");
        game.changeState();
        game.triggerCircle();
        game.triggerTriangle();
        game.triggerSquare();


    }
}
