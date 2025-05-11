package DesignPatterns.Structural.Adapter.Message;

public class VoiceTextMessageAdapter implements TextMessage{

    VoiceMessage voiceMessage;

    public VoiceTextMessageAdapter(VoiceMessage voiceMessage) {
        this.voiceMessage = voiceMessage;
    }

    @Override
    public void send(String message) {
        System.out.println("This is the text that converted voice to text message.\nText:");
        voiceMessage.sendVoiceMessage(message);
    }
}
