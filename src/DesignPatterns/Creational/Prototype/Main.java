package DesignPatterns.Creational.Prototype;

// Creational
// Prototype : Nesne oluşturma maliyetinin yüksek olduğu durumlarda kullanılan bir creational (oluşturucu) tasarım desenidir.
// Bu desenin temel amacı, mevcut bir nesnenin kopyasını oluşturarak yeni nesne üretimini kolaylaştırmak ve maliyetini düşürmektir.


public class Main {

    public static void main(String[] args) {
        Long now = System.currentTimeMillis();
        Contact contact = new Contact("1234567890", "email@gmail.com", "address1");
        Person personWithoutCloning = new Person("Muharrem", "Aslan", 25, contact);
        Long end = System.currentTimeMillis();
        System.out.println("Time for creating an Object without cloninig");
        calculateTime(now, end);
        System.out.println(personWithoutCloning.toString());

        Long now2 = System.currentTimeMillis();

        Person personCloned = null;
        try {
            personCloned = (Person) personWithoutCloning.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        Long end2 = System.currentTimeMillis();
        System.out.println("\nTime for creating an Object with cloninig");
        System.out.println(now2);
        System.out.println(end2);
        calculateTime(now2, end2);

        System.out.println(personCloned.toString());

        System.out.println("\nDeep Copy");

        Person personClonedDeep = null;
        try {
            personClonedDeep = personWithoutCloning.cloneDeep();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(personClonedDeep.toString());
    }

    private static void calculateTime(Long now,Long end){
        System.out.println("Time Elapsed: "+( end-now)/1000 );
    };


}
