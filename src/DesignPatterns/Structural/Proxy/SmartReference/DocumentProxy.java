package DesignPatterns.Structural.Proxy.SmartReference;

public class DocumentProxy implements Document{

    RealDocument realDocument;
    int accessCount=0;
    @Override
    public void getDocument(String username) {
        RealDocument realDocument = new RealDocument();
        realDocument.getDocument(username);
        System.out.println(username+" Accessed to Document");
        accessCount++;
        System.out.println("Access Count: "+accessCount);
    }

}
