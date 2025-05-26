package DesignPatterns.Structural.Proxy.RemoteProxy;

public class RealServer implements Server {
    public void execute() {
        System.out.println("Executing some job on server...");
    }
}
