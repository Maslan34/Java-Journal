package DesignPatterns.Structural.Adapter.Message;

public class VoiceMessageImpl implements VoiceMessage{
    @Override
    public void sendVoiceMessage(String message) {
        System.out.println("Message vocalized "+message);
    }
}
