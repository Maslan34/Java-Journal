package DesignPatterns.Structural.Bridge.MusicExample;



// Structural
// Bridge :Temel amacı, arayüz (interface) ile bu arayüzün implementasyonlarını (uygulamalarını) birbirinden ayırarak,
// bağımsız olarak geliştirebilmeyi sağlamaktır.Bridge deseni, soyutlama (abstraction) ile uygulama (implementation) arasındaki bağlantıyı bir köprü gibi kurar.
// Bu sayede ikisini birbirinden bağımsız olarak geliştirebilirsin.
//Yani bir sınıfın işlevselliğini alt sınıflar oluşturarak genişletmek yerine, bu işlevselliği başka bir sınıfa delegasyon yoluyla vermeyi tercih eder.
// Özetle eğer bazı sınıflarınının kombinasyonları sana lazımsa Şekil(Kare,Dikdörtgen), Renk(Kırmızı Mavi) Kırmızı Kare Mavi Dikdörtgen gibi,
// Bu amaçla kullanılır.


public class Main {
    public static void main(String[] args) {

        // No Bridge Here
        Music music = new Music("Rolling in the Deep","Adele");

        Computer computer = new Computer();

        computer.playMusic(music);
        System.out.println();
        // No Bridge Here

        SuperComputer superComputer = new SuperComputer();
        superComputer.playMusic(music);
        System.out.println();

        superComputer.setMusicPlayer(new YoutubeMusic());
        superComputer.setVoiceDevice(new BassSystem());
        superComputer.playMusic(music);

    }
}
