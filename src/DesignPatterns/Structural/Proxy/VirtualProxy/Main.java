package DesignPatterns.Structural.Proxy.VirtualProxy;

import java.util.ArrayList;
import java.util.List;


// Virtual Proxynin amacı yüklemeyi ertlemek yani geç yükleme yapmak (lazy loading).Böylelikle dosylar
// gerektiğinde yükleniyor. Performans kazancı sağlanıyor.

public class Main {
    public static void main(String[] args) {
        VirtualImageProxy virtualImageProxy = new VirtualImageProxy("dog.jpg");
        virtualImageProxy.display();

    /*
        // Bu durumda hepsi yüklenir
        List<Image> images = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            images.add(new RealImage("img" + i + ".jpg")); // 100 tane görsel yükleme işlemi
            // Hem diskten çekildi için yavaş hemde bu 100 görsel ramde bulunucak.
        }
    */

        List<Image> imagesProxy = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            imagesProxy.add(new VirtualImageProxy("img" + i + ".jpg")); // henüz yükleme yok
        }

        // Kullanıcı sadece 3 tanesine tıkladı
        imagesProxy.get(5).display();   // şimdi yüklendi
        imagesProxy.get(20).display();  // şimdi yüklendi
        imagesProxy.get(70).display();  // şimdi yüklendi


    }
}
