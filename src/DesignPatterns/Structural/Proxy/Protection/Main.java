package DesignPatterns.Structural.Proxy.Protection;


public class Main {
    public static void main(String[] args) {
        DocumentProxy documentProxy = new DocumentProxy();

        String data =documentProxy.getDocument("Muharrem","12345");
        System.out.println(data);
        String data2 =documentProxy.getDocument("Ömer","54321");
        System.out.println(data2);
    }
}
