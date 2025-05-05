package DesignPatterns.Creational.AbstractFactoryMethod;


// Creational
// Abstract Factory Method : Farklı nesne türleri ailesini oluşturmak için soyut bir arayüz veya sınıfı temsil eder.
// Bu arayüz, nesnelerin nasıl oluşturulacağını tanımlayan metotları içerir.


public class Main {
    public static void main(String[] args) {

        TelephoneFactoryIMPL factory = new TelephoneFactoryIMPL();

        Telephone s8 = factory.createTelephone("S");
        Telephone note = factory.createTelephone("Note");

        s8.call();
        note.call();


        SFactory s8Factory = new SFactory();
        NoteFactory noteFactory = new NoteFactory();

        Telephone s8FromFactory = s8Factory.createTelephone("S8");
        Telephone noteFromFactory = noteFactory.createTelephone("Note10");
        s8FromFactory.call();
        noteFromFactory.call();

        System.out.println("\nObjects Created From Non-Abstract Factory");
        System.out.println(s8.getModel());
        System.out.println(note.getModel());
        System.out.println("Objects Created From Abstract Factory");
        System.out.println(s8FromFactory.getModel());
        System.out.println(noteFromFactory.getModel());

       



    }
}
