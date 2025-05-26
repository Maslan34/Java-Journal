package DesignPatterns.Structural.Proxy.SmartReference;

public class RealDocument implements Document {
    @Override
    public void getDocument(String username) {
        System.out.println("Printing document...");

    }
}
