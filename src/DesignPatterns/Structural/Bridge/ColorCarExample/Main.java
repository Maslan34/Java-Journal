package DesignPatterns.Structural.Bridge.ColorCarExample;


// Structural
// Bridge :Temel amacı, arayüz (interface) ile bu arayüzün implementasyonlarını (uygulamalarını) birbirinden ayırarak,
// bağımsız olarak geliştirebilmeyi sağlamaktır.Bridge deseni, soyutlama (abstraction) ile uygulama (implementation) arasındaki bağlantıyı bir köprü gibi kurar.
// Bu sayede ikisini birbirinden bağımsız olarak geliştirebilirsin.
//Yani bir sınıfın işlevselliğini alt sınıflar oluşturarak genişletmek yerine, bu işlevselliği başka bir sınıfa delegasyon yoluyla vermeyi tercih eder.
// Özetle eğer bazı sınıflarınının kombinasyonları sana lazımsa Şekil(Kare,Dikdörtgen), Renk(Kırmızı Mavi) Kırmızı Kare Mavi Dikdörtgen gibi,
// Bu amaçla kullanılır.

public class Main {
    public static void main(String[] args) {

        AnatolianRed red=new AnatolianRed();
        GemlikBlue blue=new GemlikBlue();

        T10f t10f = new T10f(red);
        T10f t10f1 = new T10f(blue);

        T10x t10x = new T10x(red);
        T10x t10x1 = new T10x(blue);
    }
}
