package DesignPatterns.Creational.Builder;


// Creational
// Builder :  Nesne oluşturma işlemini daha kontrollü ve okunabilir hale getirmek için kullanılan bir yaratıcı (creational) tasarım desenidir.
// Özellikle karmaşık nesnelerin oluşturulmasında, Çok sayıda parametreye sahip sınıflarda (özellikle opsiyonel parametrelerde)tercih edilir.
// Immutable (değiştirilemez) nesneler oluştururken de kullanılan bir design patterndir.

public class Main {
    public static void main(String[] args) {

        // Classic Builder -> instantiating using static Class method
        UserClassic userClassic = new UserClassic.Builder("ClassicBuilder","12345")
                .age(23).name("Muharrem").build();

        System.out.println(userClassic);

        // Modern Builder -> Fluent Api --> instantiating using object itself
        UserModern userModern = new UserModern().builder("ModernBuilder","12345")
                .age(23).name("Muharrem").build();
        System.out.println(userModern);

    }
}
