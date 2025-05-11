package DesignPatterns.Structural.Adapter.Message;



// Structural
// Adapter : Birbirleriyle uyumsuz olan arayüzlerin birlikte çalışmasını sağlamak için kullanılır.
// Başka bir deyişle, bir sınıfın arayüzünü, istemcinin beklediği başka bir arayüze dönüştürür.
//Burada Adapter yardımı ile VoiceMessage, TextMessage'a dönüştürüldü.
public class Main {
    public static void main(String[] args) {
        TestMessageImpl testMessageImpl = new TestMessageImpl();
        VoiceMessageImpl voiceMessageImpl = new VoiceMessageImpl();

        testMessageImpl.send("Hi!");
        voiceMessageImpl.sendVoiceMessage("Bööö!");

        VoiceTextMessageAdapter voiceTextMessageAdapter = new VoiceTextMessageAdapter(voiceMessageImpl);
        voiceTextMessageAdapter.send("Bööö!");

    }
}
