package DesignPatterns.Structural.Adapter.Voltage;


// Structural
// Adapter : Birbirleriyle uyumsuz olan arayüzlerin birlikte çalışmasını sağlamak için kullanılır.
// Başka bir deyişle, bir sınıfın arayüzünü, istemcinin beklediği başka bir arayüze dönüştürür.
// Burada TelephoneAdapter yardımı ile Telephone Arayüzü, HomeAppliance arayüzüne dönüştürüldü.

public class Main {
    public static void main(String[] args) {

        Socket socket = new Socket();

        Iron  iron  = new Iron();
        Fridge fridge  = new Fridge();
        IPhone iphone  = new IPhone();

        socket.giveElectricity(iron);
        socket.giveElectricity(fridge);
        // socket.giveElectricity(iphone); -> incompatible Interface
        TelephoneAdapter telephoneAdapter = new TelephoneAdapter(iphone);

        socket.giveElectricity(telephoneAdapter);

    }
}
