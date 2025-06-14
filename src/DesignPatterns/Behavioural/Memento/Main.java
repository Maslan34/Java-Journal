package DesignPatterns.Behavioural.Memento;


// Behavioural
// Memento :Bir nesnenin önceki durumunu kaydetmek ve gerektiğinde bu duruma geri dönebilmek için kullanılan
// bir davranışsal tasarım kalıbıdır.Nesnenin iç durumunu kapsülleme ilkesini bozmadan durum kaydı yapılabilir.
//  Kullanım Alanları;

//  Undo/Redo işlemleri: Metin editörleri, grafik uygulamaları
//  Oyunlarda kaydet/yükle: Oyun durumlarını kaydetme
//  İşlem geçmişi: Bankacılık uygulamalarında işlem geçmişi
//  Yapılandırma yönetimi: Sistem ayarlarının önceki versiyonlarına dönme

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();
        editor.setContent("Hello World");
        history.push(editor.createState());
        editor.setContent("Muharrem");
        history.push(editor.createState());
        editor.setContent("Aslan");
        history.push(editor.createState());
        editor.setContent("Türkiye");
        history.push(editor.createState());

        editor.restoreState(history.pop());
        System.out.println("Editor content: " + editor.getContent());
        editor.restoreState(history.pop());
        System.out.println("Editor content: " + editor.getContent());


    }
}
