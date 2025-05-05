package DesignPatterns.Creational.FactoryMethod.CarExample;


// Creational
// Factory Method : "New" ' lemenin bir sorun olduğu zaman kullanılır.
// Ara bir "Factory" classı eklenerek.Alt sınıflarda New'leme işlemleri buralarda yapılır.

// Sonuç: Factory Method tasarım deseni, farklı türdeki nesnelerin yaratılmasını kolaylaştırır ve esneklik sağlar.
public class Main {
    public static void main(String[] args) {

        // Sedan otomobil fabrikasını kullanarak otomobil üretme
        CarFactory sedanFactory = new SedanCarFactory();
        Car sedan = sedanFactory.createCar();
        sedan.create();

        // SUV otomobil fabrikasını kullanarak otomobil üretme
        CarFactory suvFactory = new SuvCarFactory();
        Car suv = suvFactory.createCar();
        suv.create(); // Çıktı: SUV car is created.
    }
}
