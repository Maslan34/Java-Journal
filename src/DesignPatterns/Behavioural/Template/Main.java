package DesignPatterns.Behavioural.Template;


// Behavioural
// Template :Amacı, bir algoritmanın iskeletini (yani adımlarını) bir üst sınıfta tanımlamak,
// ama bu adımlardan bazılarını alt sınıflara bırakarak özelleştirmeye izin vermektir.
// Bir algoritmanın genel yapısını bir final metot ile belirler.


// Avantajları:
// Kod tekrarı azalır.
// Değişime açık, ama iskelete sadık bir yapı kurulur.Yani SOLID prensiplerinden Open/Closed ilkesine uygundur.


// Dezavantajları
// Çok fazla abstract sınıf varsa kod karmaşıklaşabilir.
// Tüm adımlar her alt sınıf için uygun olmayabilir (bazılarını boş geçmek gerekebilir)

public class Main {
    public static void main(String[] args) {
        System.out.println("Preparing Tea: ");
        Beverage tea = new Tea();
        tea.prepareBeverage();

        System.out.println("\nPreparing Coffee: ");
        Beverage coffee = new Coffee();
        coffee.prepareBeverage();
    }
}
