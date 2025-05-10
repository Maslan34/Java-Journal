package DesignPatterns.Creational.Singleton;


// Creational
// Singleton : Bir sınıftan yalnızca bir adet nesne (instance) oluşturulmasını garanti altına alan ve
// bu nesneye global bir erişim noktası sağlayan bir tasarım desenidir.
// Çok iş parçacıklı (multithreaded) ortamlarda getInstance() metodu senkronize edilmelidir.
//Bu durumlarda Thread-safe Singleton ya da Enum tabanlı Singleton çözümleri tercih edilir.
// Bu yapıda thread-safe yazıldı.

public class Main {
    public static void main(String[] args) {
        House house1 = House.getInstance();
        System.out.println(house1);
        house1.setAge(5);
        System.out.println(house1);
        House house2 = House.getInstance();
        System.out.println(house2);

        System.out.println("Is House 1 == House2? "+ (house1 == house2));

    }
}
