package DesignPatterns.Structural.Adapter.Message;

public class TestMessageImpl implements TextMessage{

    @Override
    public void send(String message) {
        System.out.println("Message sent: " + message);
    }
}
