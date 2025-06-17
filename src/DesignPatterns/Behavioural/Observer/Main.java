package DesignPatterns.Behavioural.Observer;



// Behavioural
// Observer :Bir nesnedeki değişikliklerin,
// bu nesneye bağlı diğer nesnelere (observers, yani gözlemciler) otomatik olarak bildirilmesini sağlayan
// bir davranışsal (behavioral) tasarım desenidir.
// "Publish-Subscribe" mantığına dayanır: bir nesne veri yayınlar (subject), diğerleri buna abonedir

// Avantajları:
// Observer’lar gevşek bağlıdır (loosely coupled).
// Yeni gözlemciler kolayca eklenebilir.
// Etkin ve dinamik haberleşme sağlar.

// Dezavantajları:
// Çok fazla gözlemci olduğunda performans etkilenebilir.
// Bildirim sırası garanti edilmez.


public class Main {
    public static void main(String[] args) {

        Parent mom = new Parent("Huriye");
        Parent dad = new Parent("Yusuf");

        Thermometer thermometer = new Thermometer(22,29);
        System.out.println("Current Temperature of Thermometer: "+thermometer.getCurrentTemperature());

        thermometer.addObserver(mom);
        for(int i=1;i<10;i++){

            thermometer.setCurrentTemperature(thermometer.getCurrentTemperature()+1);
        }


    }
}
